grammar unnamedLanguage;

options
{
    backtrack=true;
}

@parser::header {
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
}

@lexer::header {
}
  
@members
{
protected void mismatch (IntStream input, int ttype, BitSet follow)
        throws RecognitionException
{
        throw new MismatchedTokenException(ttype, input);
}
public Object recoverFromMismatchedSet (IntStream input,
                                      RecognitionException e,
                                      BitSet follow)
        throws RecognitionException
{
        reportError(e);
        throw e;
}
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}

/* Parser */

program returns [Program p]
@init
{
	p = new Program();
}
    : (f=function {p.addFunction(f);})+ EOF
	;

function returns [Function f]
    : fd=functionDecl fb=functionBody {f = new Function(fd,fb);}
	;

functionDecl returns [FunctionDeclaration fd]
    : p1=formalParameter {fd = new FunctionDeclaration(p1);} 
    OPENPAREN (p2=formalParameter {fd.addParameter(p2);}(COMMA pi=formalParameter {fd.addParameter(pi);})*)? CLOSEPAREN
	;

formalParameter returns [FormalParameter p]
    : c=compoundType id=identifier {p=new FormalParameter(c,id);}
    ;

compoundType returns [Type t]
    : x=type {t=x;}(OPENBRACKET sz=INTLIT CLOSEBRACKET {t=new ArrayType(new IntegerLiteral(Integer.valueOf(sz.getText()),$sz.line,$sz.pos),x);})?
    ;

functionBody returns [FunctionBody fb]
    : OPENBRACE {fb = new FunctionBody();}
    (vd=variableDecl {fb.addVariableDeclaration(vd);})* (s=statement {fb.addStatement(s);})* CLOSEBRACE
	;

variableDecl returns [VariableDeclaration vd]
    : c=compoundType id=identifier SEMICOLON {vd = new VariableDeclaration(c,id);}
    ;

statement returns [Statement s]
         : x=emptyStmt {s=x;}
         | x=expressionStmt {s=x;}
         | x=ifElseStmt {s=x;}
         | x=whileStmt {s=x;}
         | x=printStmt {s=x;}
         | x=printlnStmt {s=x;}
         | x=returnStmt {s=x;}
         | x=assignStmt {s=x;}
         | x=arrAssignStmt {s=x;}
    ;

emptyStmt returns [Statement s]
    : SEMICOLON {s= new EmptyStatement();} 
    ;

expressionStmt returns [Statement s]
    : e=expression SEMICOLON {s = new ExpressionStatement(e);}
    ;

ifElseStmt returns [IfElseStatement s]
    : IF OPENPAREN e=expression CLOSEPAREN b=block {s= new IfElseStatement(e,b);}
    (ELSE b2=block {s.setElseBlock(b2);})?
    ;

whileStmt returns [Statement s]
    : WHILE OPENPAREN e=expression CLOSEPAREN b=block {s= new WhileStatement(e,b);}
    ;

printStmt returns [Statement s]
    : PRINT e=expression SEMICOLON {s= new PrintStatement(e);}
    ;

printlnStmt returns [Statement s]
    : PRINTLN e=expression SEMICOLON {s= new PrintlnStatement(e);}
    ;

returnStmt returns [ReturnStatement s]
    : x=RETURN {s= new ReturnStatement($x.line,$x.pos);} (e=expression {s.setReturnExpression(e);})? SEMICOLON
    ;

assignStmt returns [Statement s]
    : id=identifier ASSIGNOP e=expression SEMICOLON {s= new AssignmentStatement(id,e);}
    ;

arrAssignStmt returns [Statement s]
    : ar=arrayReference ASSIGNOP e=expression SEMICOLON {s= new ArrayAssignmentStatement(ar,e);}
    ;

block returns [Block b]
    : OPENBRACE {b = new Block();} (s=statement {b.addStatement(s);})* CLOSEBRACE
    ;

expression returns [Expression e]
    : e1=equalityExpr {e=e1;}
    ;

equalityExpr returns [Expression e]
    : e1=lessThanExpr {e=e1;} (EQUALITYOP e2=lessThanExpr {e= new EqualityExpression(e,e2);})*
    ;

lessThanExpr returns [Expression e]
    : e1=addSubExpr {e=e1;} (LESSTHANOP e2=addSubExpr {e= new LessThanExpression(e,e2);})*
    ;

addSubExpr returns [Expression e]
    : e1=multExpr {e=e1;} ((x=ADDOP|x=SUBOP) e2=multExpr 
    {if(x.getText().compareTo("+") == 0){ e = new AddExpression(e,e2);}else{ e = new SubExpression(e,e2);}})*
    ;

multExpr returns [Expression e]
    : e1=atomExpr {e=e1;} (MULTOP e2=atomExpr {e= new MultExpression(e,e2);})*
    ;

atomExpr returns [Expression e]
    : x=arrayReference {e=x;}
    | x=functionCall {e=x;}
    | x=identifier {e=x;}
    | x=literal {e=x;}
    | x=parenthesizedExpr {e=x;}
    ;

arrayReference returns [ArrayReference e]
    : id=identifier OPENBRACKET e1=expression CLOSEBRACKET {e = new ArrayReference(id,e1);}
    ;

functionCall returns [FunctionCall e]
    : id=identifier {e=new FunctionCall(id);}
    OPENPAREN (e1=expression {e.addArgument(e1);}(COMMA ei=expression {e.addArgument(ei);})*)? CLOSEPAREN
    ;

parenthesizedExpr returns [Expression e]
    : OPENPAREN x=expression CLOSEPAREN {e= new ParenthesizedExpression(x);}
    ;

literal returns [Literal l]
    : x=strLit {l=x;}
    | x=intLit {l=x;}
    | x=floatLit {l=x;}
    | x=charLit {l=x;}
    | x=boolLit {l=x;}
    ;

strLit returns [Literal s]
    : x=STRLIT {int len = x.getText().length(); s = new StringLiteral(x.getText().substring(1,len-1),$x.line,$x.pos);}
    ;

intLit returns [Literal i]
    : x=INTLIT {i = new IntegerLiteral(Integer.valueOf(x.getText()),$x.line,$x.pos);}
    ;

floatLit returns [Literal f]
    : x=FLOATLIT {f = new FloatLiteral(Float.valueOf(x.getText()),$x.line,$x.pos);}
    ;

charLit returns [Literal c]
    : x=CHARLIT {c = new CharacterLiteral(x.getText().charAt(1),$x.line,$x.pos);}
    ;

boolLit returns [Literal b]
    : x=BOOLLIT {b = new BooleanLiteral(Boolean.valueOf($x.text),$x.line,$x.pos);}
    ;

type returns [Type t]
    : x=strType {t=x;}
    | x=intType {t=x;}
    | x=floatType {t=x;}
    | x=charType {t=x;}
    | x=boolType {t=x;}
    | x=voidType {t=x;}
    ;

strType returns [Type t]
    : x=STRTYPE {t = new StringType($x.line,$x.pos);}
    ;

intType returns [Type t]
    : x=INTTYPE {t = new IntegerType($x.line,$x.pos);}
    ;

floatType returns [Type t]
    : x=FLOATTYPE {t = new FloatType($x.line,$x.pos);}
    ;

charType returns [Type t]
    : x=CHARTYPE {t = new CharacterType($x.line,$x.pos);}
    ;

boolType returns [Type t]
    : x=BOOLTYPE {t = new BooleanType($x.line,$x.pos);}
    ;

voidType returns [Type t]
    : x=VOIDTYPE {t = new VoidType($x.line,$x.pos);}
    ;

identifier returns [Identifier id]	
	: i=ID {id = new Identifier($i.text,$i.line,$i.pos);}
	;


/* Lexer */

OPENPAREN: '('
    ;

CLOSEPAREN: ')'
    ;

OPENBRACE: '{'
    ;

CLOSEBRACE: '}'
    ;

OPENBRACKET: '['
    ;

CLOSEBRACKET: ']'
    ;

SEMICOLON: ';'
    ;

COMMA: ','
    ;

ASSIGNOP: '='
    ;

EQUALITYOP: '=='
    ;

LESSTHANOP: '<'
    ;

ADDOP: '+'
    ;

SUBOP: '-'
    ;

MULTOP: '*'
    ;

IF: 'if'
	;

ELSE: 'else'
	;

WHILE: 'while'
    ;

PRINT: 'print'
    ;

PRINTLN: 'println'
    ;

RETURN: 'return'
    ;

STRTYPE: 'string'
    ;

FLOATTYPE: 'float'
    ;

CHARTYPE: 'char'
    ;

INTTYPE: 'int'
    ;

BOOLTYPE: 'boolean'
    ;

VOIDTYPE: 'void'
    ;
    
BOOLLIT: 'true'|'false'
    ;

STRLIT: '"' (('a'..'z')|('A'..'Z')|'_'|'!'|'\.'|COMMA|':'|' '|OPENBRACE|CLOSEBRACE|('0'..'9'))* '"'
    ;
    
CHARLIT: '\'' (('a'..'z')|('A'..'Z')|'_'|'!'|'\.'|COMMA|':'|' '|OPENBRACE|CLOSEBRACE|('0'..'9')) '\''
    ;

INTLIT: ('0'..'9')+
    ;

FLOATLIT: ('0'..'9')+ '\.' ('0'..'9')+
    ;

ID	: (('a'..'z')|('A'..'Z')|'_')(('a'..'z')|('A'..'Z')|'_'|('0'..'9'))*
	;


/* These two lines match whitespace and comments 
 * and ignore them.
 */
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;