package Visitors;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;

public class TypeVisitor extends Visitor<Type>
{
    private Environment<String,FunctionDeclaration> functionEnvironment;
    private Environment<String,Type> variableEnvironment;
    private Function currentFunction;
    
    private boolean isAtomicType(Type t)
    {
        return (!(t instanceof ArrayType) && !(t instanceof VoidType));
    }
    
    public TypeVisitor()
    {
        functionEnvironment = new Environment<String,FunctionDeclaration>();
        variableEnvironment = new Environment<String,Type>();
    }

    public Type visit(Program p) throws Exception
    {
		int functionCount = p.getFunctionCount();
		
        for (int i=0;i<functionCount;i++)
		{
            FunctionDeclaration funcDecl = p.getFunctionAt(i).getFuncDecl();
            String funcName = funcDecl.getSignature().getID().getName();
            if(functionEnvironment.containsInScope(funcName))
            {
                throw new SemanticException("Function name \""+funcName+"\" is already in use.", funcDecl.getLine(),funcDecl.getOffset());
            }
            functionEnvironment.push(funcName,funcDecl);
		}
        
        //Ensure main function meets criteria
        FunctionDeclaration mainFunc = functionEnvironment.getInScope("main");
        
        if(mainFunc == null){
            
            throw new SemanticException("No function named \"main\".", p.getLine(),p.getOffset());
            
        }else if(!(mainFunc.getSignature().getType() instanceof VoidType)){
            
            throw new SemanticException("Main function must be of type [void].", mainFunc.getLine(),mainFunc.getOffset());
            
        }else if (mainFunc.getParameterCount()!=0){
            
            throw new SemanticException("Main function may not take parameters.", mainFunc.getLine(),mainFunc.getOffset());
            
        }
        
		for (int i=0;i<functionCount;i++)
		{
			visit(p.getFunctionAt(i));
		}
		return null;
	}
    
	public Type visit(Function f) throws Exception
    {   
        currentFunction = f;
        variableEnvironment.beginScope();
        visit(f.getFuncDecl());
        visit(f.getFuncBody());
        variableEnvironment.endScope();
        return null;
    }
    
    public Type visit(FunctionDeclaration fd) throws Exception
    {
        if( (fd.getSignature().getType() instanceof ArrayType) && (((ArrayType)fd.getSignature().getType()).getType() instanceof VoidType))
        {
            throw new SemanticException("Void arrays are not allowed.", fd.getLine(),fd.getOffset());
        }
        
        int params = fd.getParameterCount();
        for (int i=0;i<params;i++)
        {
            FormalParameter param = fd.getParameterAt(i);
            if((param.getType() instanceof VoidType) || ((param.getType() instanceof ArrayType) && (((ArrayType)param.getType()).getType() instanceof VoidType)))
            {
                throw new SemanticException("Function parameters may not be of type [void].", param.getType().getLine(),param.getType().getOffset());
            }
            
            visit(param);
        }
        return null;
    }
    
    public Type visit(FunctionBody fb) throws Exception
    {        
        int varDeclCount = fb.getVarDeclCount();
		
		for (int i=0;i<varDeclCount;i++)
		{
            VariableDeclaration vd = fb.getVarDeclAt(i);
            if((vd.getType() instanceof VoidType) || ((vd.getType() instanceof ArrayType) && (((ArrayType)vd.getType()).getType() instanceof VoidType)))
            {
                throw new SemanticException("Variables may not be of type [void].", vd.getType().getLine(), vd.getType().getOffset());
            }
            
			visit(vd);
		}
        
        int stmtCount = fb.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
			visit(fb.getStatementAt(i));
		}
        return null;
    }
    
	public Type visit(FormalParameter p) throws Exception
    {        
        if(variableEnvironment.containsInScope(p.getID().getName()))
        {
            throw new SemanticException("Parameter name \""+p.getID().getName()+"\" is already in use.", p.getLine(),p.getOffset());
        }
        variableEnvironment.push(p.getID().getName(),p.getType());
        return null;
    }

	public Type visit(VariableDeclaration vd) throws Exception
    {
        if(variableEnvironment.containsInScope(vd.getID().getName()))
        {
            throw new SemanticException("Variable name \""+vd.getID().getName()+"\" is already in use.", vd.getLine(),vd.getOffset());
        }
        variableEnvironment.push(vd.getID().getName(),vd.getType());
        return null;
    }
    
    public Type visit(EmptyStatement s) throws Exception
    {
        return null;
    }
    
    public Type visit(AssignmentStatement a) throws Exception
    {
        Type t1 = visit(a.getID());
		Type t2 = visit(a.getExpression());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Assignment statement tries to assign expression with type ["+t2.toString()+"] to variable with type ["+t1.toString()+"].", a.getExpression().getLine(), a.getExpression().getOffset());
        }
        return null;
    }

	public Type visit(ArrayAssignmentStatement aa) throws Exception
    {
        Type t1 = visit(aa.getArrayReference());
		Type t2 = visit(aa.getExpression());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Assignment statement tries to assign expression with type ["+t2.toString()+"] to variable with type ["+t1.toString()+"].", aa.getExpression().getLine(), aa.getExpression().getOffset());
        }
        return null;
    }

	public Type visit(ExpressionStatement e) throws Exception
    {
        return visit(e.getExpression());
    }

	public Type visit(IfElseStatement ie) throws Exception
    {
        Type t = visit(ie.getExpression());
        if(!(t instanceof BooleanType))
        {
            throw new SemanticException("Conditional expression must be of type [boolean].", ie.getExpression().getLine(), ie.getExpression().getOffset());
        }
        
        visit(ie.getIfBlock());
        if(ie.getElseBlock() != null)
        {
            visit(ie.getElseBlock());
        }
        return null;
    }

	public Type visit(PrintlnStatement p) throws Exception
    {
        Type t = visit(p.getExpression());
        
        if(!(isAtomicType(t)))
        {
            throw new SemanticException("Println expression must be an atomic type.\nAtomic types include the following: int, float, char, string, boolean.", p.getExpression().getLine(), p.getExpression().getOffset());
        }
        return null;
    }

	public Type visit(PrintStatement p) throws Exception
    {
         Type t = visit(p.getExpression());
        
        if(!(isAtomicType(t)))
        {
            throw new SemanticException("Print expression must be an atomic type.\nAtomic types include the following: int, float, char, string, boolean.", p.getExpression().getLine(), p.getExpression().getOffset());
        }
        return null;
    }

	public Type visit(ReturnStatement r) throws Exception
    {
        Type funcType = currentFunction.getFuncDecl().getSignature().getType();
        if(r.getExpression() == null)
        {
            if(!(funcType instanceof VoidType))
            {
                throw new SemanticException("Return statement must match return type of function.", r.getLine(), r.getOffset());
            }
        }
        else
        {
            Type t = visit(r.getExpression());
            if(!(t.equals(funcType)))
            {
                throw new SemanticException("Return statement must match return type of function.", r.getExpression().getLine(), r.getExpression().getOffset());
            }
        }
        return null;
    }

	public Type visit(WhileStatement w) throws Exception
    {
        Type t = visit(w.getExpression());
        if(!(t instanceof BooleanType))
        {
            throw new SemanticException("Conditional expression must be of type [boolean].", w.getExpression().getLine(), w.getExpression().getOffset());
        }
        visit(w.getBlock());
        return null;
    }

    public Type visit(Block b) throws Exception
    {
        int stmtCount = b.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
			visit(b.getStatementAt(i));
		}
        return null;
    }

	public Type visit(AddExpression a) throws Exception
    {
        Type t1 = visit(a.getLHS());
        Type t2 = visit(a.getRHS());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Addition of incompatible types: ["+t1.toString()+"] and ["+t2.toString()+"].", a.getRHS().getLine(), a.getRHS().getOffset());
        }
        else if((t1 instanceof BooleanType) || (t1 instanceof VoidType) || (t1 instanceof ArrayType))
        {
            throw new SemanticException("Addition operator does not operate on type ["+t1.toString()+"].", a.getLHS().getLine(), a.getLHS().getOffset());
        }
        return t1;
    }

	public Type visit(EqualityExpression eq) throws Exception
    {
        Type t1 = visit(eq.getLHS());
        Type t2 = visit(eq.getRHS());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Comparison of incompatible types: ["+t1.toString()+"] and ["+t2.toString()+"].", eq.getRHS().getLine(), eq.getRHS().getOffset());
        }
        else if((t1 instanceof VoidType) || (t1 instanceof ArrayType))
        {
            throw new SemanticException("Equality operator does not operate on type ["+t1.toString()+"].", eq.getLHS().getLine(), eq.getLHS().getOffset());
        }
        return new BooleanType(eq.getLine(), eq.getOffset());
    }

	public Type visit(LessThanExpression lt) throws Exception
    {
        Type t1 = visit(lt.getLHS());
        Type t2 = visit(lt.getRHS());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Comparison of incompatible types: ["+t1.toString()+"] and ["+t2.toString()+"].", lt.getRHS().getLine(), lt.getRHS().getOffset());
        }
        else if((t1 instanceof VoidType) || (t1 instanceof ArrayType))
        {
            throw new SemanticException("LessThan operator does not operate on type ["+t1.toString()+"].", lt.getLHS().getLine(), lt.getLHS().getOffset());
        }
        return new BooleanType(lt.getLine(), lt.getOffset());
    }

	public Type visit(MultExpression m) throws Exception
    {
        Type t1 = visit(m.getLHS());
        Type t2 = visit(m.getRHS());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Multiplication of incompatible types: ["+t1.toString()+"] and ["+t2.toString()+"].", m.getRHS().getLine(), m.getRHS().getOffset());
        }
        else if(!(t1 instanceof IntegerType) && !(t1 instanceof FloatType))
        {
            throw new SemanticException("Multiplication operator does not operate on type ["+t1.toString()+"].", m.getLHS().getLine(), m.getLHS().getOffset());
        }
        return t1;
    }

	public Type visit(SubExpression s) throws Exception
    {
        Type t1 = visit(s.getLHS());
        Type t2 = visit(s.getRHS());
        if(!(t1.equals(t2)))
        {
            throw new SemanticException("Subtraction of incompatible types: ["+t1.toString()+"] and ["+t2.toString()+"].", s.getRHS().getLine(), s.getRHS().getOffset());
        }
        else if(!(t1 instanceof IntegerType) && !(t1 instanceof FloatType) && !(t1 instanceof CharacterType))
        {
            throw new SemanticException("Subtraction operator does not operate on type ["+t1.toString()+"].", s.getLHS().getLine(), s.getLHS().getOffset());
        }
        return t1;
    }

    public Type visit(FunctionCall f) throws Exception
    {
        FunctionDeclaration fd = functionEnvironment.getInScope(f.getID().getName());
        if(fd == null){
            throw new SemanticException("Function \""+f.getID().getName()+"\" could not be found.", f.getLine(), f.getOffset());
        }
        
        int args = f.getArgumentCount();
        int params = fd.getParameterCount();
        
        if(args != params)
        {
            throw new SemanticException("Incorrect number of arguments passed to function \""+f.getID().getName()+"\".", f.getLine(), f.getOffset());
        }
        
        for (int i=0;i<args;i++)
        {
            Type argType = visit(f.getArgumentAt(i));
            Type paramType = fd.getParameterAt(i).getType();
            if(!(argType.equals(paramType)))
            {
                throw new SemanticException("Argument of type ["+argType.toString()+"] was passed when function expected type ["+paramType.toString()+"].", f.getArgumentAt(i).getLine(), f.getArgumentAt(i).getOffset());
            }
        }
        return fd.getSignature().getType();
    }

	public Type visit(ArrayReference a) throws Exception
    {
        Type t = visit(a.getID());
        if(!(t instanceof ArrayType))
        {
            throw new SemanticException("Attempted to access \""+a.getID().getName()+"\" as an array when it is of type ["+t.toString()+"].", a.getLine(), a.getOffset());
        }
        
        //safe to do because the above if statement catches every other case
        ArrayType at = (ArrayType)t;
        
        //need to evaluate expression to determine if index is out of range???
        //if(a.getIndex() < 0 || a.getIndex() >= at.size.value) report error
        
        if(!(visit(a.getIndex()) instanceof IntegerType))
        {
            throw new SemanticException("Array indexes must be of type [int].", a.getIndex().getLine(), a.getIndex().getOffset());
        }
        return at.getType();
    }

    //The default assumption is that an identifier identifies a variable.
    //If this is not the case (e.g. function call), do not call this method.
	public Type visit(Identifier i) throws Exception
    {
        Type t = variableEnvironment.getInScope(i.getName());
        if(t == null){
            throw new SemanticException("Identifier \""+i.getName()+"\" could not be found in the current scope.", i.getLine(), i.getOffset());
        }
        return t;
    }

	public Type visit(ParenthesizedExpression e) throws Exception
    {
        return visit(e.getExpression());
    }

	public Type visit(BooleanLiteral b) throws Exception
    {
        return new BooleanType(b.getLine(), b.getOffset());
    }

	public Type visit(CharacterLiteral c) throws Exception
    {   
        return new CharacterType(c.getLine(), c.getOffset());
    }

	public Type visit(FloatLiteral f) throws Exception
    {
        return new FloatType(f.getLine(), f.getOffset());
    }

	public Type visit(IntegerLiteral i) throws Exception
    {
        return new IntegerType(i.getLine(), i.getOffset());
    }

	public Type visit(StringLiteral s) throws Exception
    {
        return new StringType(s.getLine(), s.getOffset());
    }

	public Type visit(ArrayType a) throws Exception
    {
        return a;
    }

	public Type visit(BooleanType b) throws Exception
    {
        return b;
    }

	public Type visit(CharacterType c) throws Exception
    {
        return c;
    }

	public Type visit(FloatType f) throws Exception
    {
        return f;
    }

	public Type visit(StringType s) throws Exception
    {
        return s;
    }

    public Type visit(IntegerType i) throws Exception
    {
        return i;
    }

	public Type visit(VoidType v) throws Exception
    {
        return v;
    }
	
}
