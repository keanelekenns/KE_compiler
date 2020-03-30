package Visitors;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import IR.*;

public abstract class Visitor<T>
{
    //ASTNode Top Level
    public T visit(ASTNode node) throws Exception
    {
        if(node instanceof Program){return visit((Program)node);}
        else if(node instanceof Function){return visit((Function)node);}
        else if(node instanceof FunctionDeclaration){return visit((FunctionDeclaration)node);}
        else if(node instanceof FunctionBody){return visit((FunctionBody)node);}
        else if(node instanceof FormalParameter){return visit((FormalParameter)node);}
        else if(node instanceof VariableDeclaration){return visit((VariableDeclaration)node);}
        else if(node instanceof Block){return visit((Block)node);}
        else if(node instanceof Statement){return visit((Statement)node);}
        else if(node instanceof Expression){return visit((Expression)node);}
        else if(node instanceof Type){return visit((Type)node);}
        else{throw new Exception("Visitor only visits subclasses of ASTNode");}
    }
    
    public	abstract T	visit(Program p) throws Exception;
	public	abstract T  visit(Function f) throws Exception;
	public	abstract T	visit(FunctionDeclaration fd) throws Exception;
    public	abstract T	visit(FunctionBody fb) throws Exception;
	public	abstract T	visit(FormalParameter p) throws Exception;
	public  abstract T	visit(VariableDeclaration vd) throws Exception;
    public  abstract T	visit(Block b) throws Exception;
    
    
    //Statements
    public T visit(Statement node) throws Exception
    {
        if(node instanceof EmptyStatement){return visit((EmptyStatement)node);}
        else if(node instanceof AssignmentStatement){return visit((AssignmentStatement)node);}
        else if(node instanceof ArrayAssignmentStatement){return visit((ArrayAssignmentStatement)node);}
        else if(node instanceof ExpressionStatement){return visit((ExpressionStatement)node);}
        else if(node instanceof IfElseStatement){return visit((IfElseStatement)node);}
        else if(node instanceof PrintlnStatement){return visit((PrintlnStatement)node);}
        else if(node instanceof PrintStatement){return visit((PrintStatement)node);}
        else if(node instanceof ReturnStatement){return visit((ReturnStatement)node);}
        else if(node instanceof WhileStatement){return visit((WhileStatement)node);}
        else{throw new Exception("Visitor only visits subclasses of ASTNode");}
    }
    
    public	abstract T	visit(EmptyStatement s) throws Exception;
    public	abstract T	visit(AssignmentStatement a) throws Exception;
	public	abstract T	visit(ArrayAssignmentStatement aa) throws Exception;
	public  abstract T	visit(ExpressionStatement e) throws Exception;
	public	abstract T	visit(IfElseStatement ie) throws Exception;
	public	abstract T	visit(PrintlnStatement p) throws Exception;
	public	abstract T	visit(PrintStatement p) throws Exception;
	public	abstract T	visit(ReturnStatement r) throws Exception;
	public	abstract T	visit(WhileStatement w) throws Exception;
    
    
    //Expressions
    public T visit(Expression node) throws Exception
    {
        if(node instanceof AddExpression){return visit((AddExpression)node);}
        else if(node instanceof EqualityExpression){return visit((EqualityExpression)node);}
        else if(node instanceof LessThanExpression){return visit((LessThanExpression)node);}
        else if(node instanceof MultExpression){return visit((MultExpression)node);}
        else if(node instanceof SubExpression){return visit((SubExpression)node);}
        else if(node instanceof FunctionCall){return visit((FunctionCall)node);}
        else if(node instanceof ArrayReference){return visit((ArrayReference)node);}
        else if(node instanceof Identifier){return visit((Identifier)node);}
        else if(node instanceof ParenthesizedExpression){return visit((ParenthesizedExpression)node);}
        else if(node instanceof Literal){return visit((Literal)node);}
        else{throw new Exception("Visitor only visits subclasses of ASTNode");}
    }
    
	public  abstract T	visit(AddExpression a) throws Exception;
	public  abstract T	visit(EqualityExpression eq) throws Exception;
	public	abstract T	visit(LessThanExpression lt) throws Exception;
	public	abstract T	visit(MultExpression m) throws Exception;
	public	abstract T	visit(SubExpression s) throws Exception;
    public	abstract T	visit(FunctionCall f) throws Exception;
	public  abstract T	visit(ArrayReference a) throws Exception;
	public  abstract T	visit(Identifier i) throws Exception;
	public	abstract T	visit(ParenthesizedExpression e) throws Exception;
    
    //Literals
    public T visit(Literal node) throws Exception
    {
        if(node instanceof BooleanLiteral){return visit((BooleanLiteral)node);}
        else if(node instanceof CharacterLiteral){return visit((CharacterLiteral)node);}
        else if(node instanceof FloatLiteral){return visit((FloatLiteral)node);}
        else if(node instanceof IntegerLiteral){return visit((IntegerLiteral)node);}
        else if(node instanceof StringLiteral){return visit((StringLiteral)node);}
        else{throw new Exception("Visitor only visits subclasses of ASTNode");}
    }
    
	public	abstract T	visit(BooleanLiteral b) throws Exception;
	public	abstract T	visit(CharacterLiteral c) throws Exception;
	public	abstract T	visit(FloatLiteral f) throws Exception;
	public  abstract T	visit(IntegerLiteral i) throws Exception;
	public	abstract T	visit(StringLiteral s) throws Exception;
    
    
    //Types
    public T visit(Type node) throws Exception
    {
        if(node instanceof ArrayType){return visit((ArrayType)node);}
        else if(node instanceof BooleanType){return visit((BooleanType)node);}
        else if(node instanceof CharacterType){return visit((CharacterType)node);}
        else if(node instanceof FloatType){return visit((FloatType)node);}
        else if(node instanceof StringType){return visit((StringType)node);}
        else if(node instanceof IntegerType){return visit((IntegerType)node);}
        else if(node instanceof VoidType){return visit((VoidType)node);}
        else{throw new Exception("Visitor only visits subclasses of ASTNode");}
    }
    
	public  abstract T	visit(ArrayType a) throws Exception;
	public	abstract T	visit(BooleanType b) throws Exception;
	public	abstract T	visit(CharacterType c) throws Exception;
	public	abstract T	visit(FloatType f) throws Exception;
	public	abstract T	visit(StringType s) throws Exception;
    public	abstract T	visit(IntegerType i) throws Exception;
	public  abstract T	visit(VoidType v) throws Exception;
}
