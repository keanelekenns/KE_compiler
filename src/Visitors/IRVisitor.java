package Visitors;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import IR.*;
import IR.IRTypes.*;
import IR.Instructions.*;
import util.*;
import java.util.*;

public class IRVisitor extends Visitor<Temp>
{
    private IRProgram program;
    private Environment<String, FunctionDeclaration> functionEnvironment;
    private Environment<String, Temp> variableEnvironment;
    private IRFunction currentFunction;
    
    public IRVisitor(String programName)
    {
        program = new IRProgram(programName);
        functionEnvironment = new Environment<String, FunctionDeclaration>();
        variableEnvironment = new Environment<String, Temp>();
    }
    
    public IRProgram getProgram()
    {
        return program;
    }

    public Temp visit(Program p) throws Exception
	{
		int functionCount = p.getFunctionCount();
		functionEnvironment.beginScope();
		for (int i=0;i<functionCount;i++)
		{
			FunctionDeclaration funcDecl = p.getFunctionAt(i).getFuncDecl();
            String funcName = funcDecl.getSignature().getID().getName();
            functionEnvironment.push(funcName, funcDecl);
		}
        
        for (int i=0;i<functionCount;i++)
		{
			visit(p.getFunctionAt(i));
		}
        
        functionEnvironment.endScope();
		return null;
	}
    
	public Temp visit(Function f) throws Exception
    {
        FunctionDeclaration funcDecl = f.getFuncDecl();
        String funcName = funcDecl.getSignature().getID().getName();
        currentFunction = new IRFunction(funcName, IRType.convertToIRType(funcDecl.getSignature().getType()));
        
        variableEnvironment.beginScope();
        visit(f.getFuncDecl());
        visit(f.getFuncBody());
        variableEnvironment.endScope();
        
        program.addFunction(currentFunction);
        return null;
    }
    
    public Temp visit(FunctionDeclaration fd) throws Exception
    {
        int params = fd.getParameterCount();
        for (int i=0;i<params;i++)
        {
            visit(fd.getParameterAt(i));
        }
        return null;
    }
    
    public Temp visit(FunctionBody fb) throws Exception
    {
        int varDeclCount = fb.getVarDeclCount();
		
		for (int i=0;i<varDeclCount;i++)
		{
			visit(fb.getVarDeclAt(i));
		}
        
        int stmtCount = fb.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
			visit(fb.getStatementAt(i));
		}
        return null;
    }
    
	public Temp visit(FormalParameter p) throws Exception
    {
        Temp t = currentFunction.getTemp(IRType.convertToIRType(p.getType()), Temp.Category.PARAM);
        
        variableEnvironment.push(p.getID().getName(), t);
        return null;
    }

	public Temp visit(VariableDeclaration vd) throws Exception
    {
        Temp t = currentFunction.getTemp(IRType.convertToIRType(vd.getType()), Temp.Category.LOCAL);
        
        variableEnvironment.push(vd.getID().getName(), t);
        
        if(t.getType() instanceof IRArrayType)
        {
            currentFunction.addInstruction(
                new NewArrayAssignment(t, 
                ((IRArrayType)t.getType()).getType(),
                ((IRArrayType)t.getType()).getSize()));
        }
        
        return null;
    }
    
    public Temp visit(EmptyStatement s) throws Exception
    {
        return null;
    }
    
    public Temp visit(AssignmentStatement a) throws Exception
    {
        Temp t1 = visit(a.getID());
		Temp t2 = visit(a.getExpression());
        currentFunction.addInstruction(new TempAssignment(t1, t2));
        return null;
    }

	public Temp visit(ArrayAssignmentStatement aa) throws Exception
    {   
        ArrayReference ar = aa.getArrayReference();
        Temp arr = variableEnvironment.getInScope(ar.getID().getName());
        Temp index = visit(ar.getIndex());
		Temp operand = visit(aa.getExpression());
        currentFunction.addInstruction(new ArrayAssignment(arr,index,operand,true));
        return null;
    }

	public Temp visit(ExpressionStatement e) throws Exception
    {
        return visit(e.getExpression());
    }

	public Temp visit(IfElseStatement ie) throws Exception
    {
        Temp conditional = visit(ie.getExpression());
        Temp notCond = currentFunction.getTemp(new IRBooleanType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new UnaryOpAssignment(notCond, UnaryOpAssignment.UnaryOp.NOT, conditional));
        
        int exit_label;
        if(ie.getElseBlock() != null)
        {
            int else_label = currentFunction.getLabelNumber();
            exit_label = currentFunction.getLabelNumber();
            currentFunction.addInstruction(new JumpInstruction(notCond, else_label));
            visit(ie.getIfBlock());
            currentFunction.addInstruction(new JumpInstruction(null, exit_label));
            currentFunction.addInstruction(new LabelInstruction(else_label));
            visit(ie.getElseBlock());
        }
        else
        {
            exit_label = currentFunction.getLabelNumber();
            currentFunction.addInstruction(new JumpInstruction(notCond, exit_label));
            visit(ie.getIfBlock());
        }
        currentFunction.addInstruction(new LabelInstruction(exit_label));
        return null;
    }

	public Temp visit(PrintlnStatement p) throws Exception
    {
        Temp t = visit(p.getExpression());
        currentFunction.addInstruction(new PrintInstruction(t,true));
        return null;
    }

	public Temp visit(PrintStatement p) throws Exception
    {
        Temp t = visit(p.getExpression());
        currentFunction.addInstruction(new PrintInstruction(t,false));
        return null;
    }

	public Temp visit(ReturnStatement r) throws Exception
    {
        Temp t = null;
        if(r.getExpression() != null)
        {
            t = visit(r.getExpression());
        }
        currentFunction.addInstruction(new ReturnInstruction(t));
        return null;
    }

	public Temp visit(WhileStatement w) throws Exception
    {
        int loop = currentFunction.getLabelNumber();
        int exit_label = currentFunction.getLabelNumber();
        
        currentFunction.addInstruction(new LabelInstruction(loop));
        
        Temp conditional = visit(w.getExpression());
        Temp notCond = currentFunction.getTemp(new IRBooleanType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new UnaryOpAssignment(notCond, UnaryOpAssignment.UnaryOp.NOT, conditional));
        
        currentFunction.addInstruction(new JumpInstruction(notCond, exit_label));
        visit(w.getBlock());
        currentFunction.addInstruction(new JumpInstruction(null, loop));
        currentFunction.addInstruction(new LabelInstruction(exit_label));
        return null;
    }

    public Temp visit(Block b) throws Exception
    {
        int stmtCount = b.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
			visit(b.getStatementAt(i));
		}
        return null;
    }

	public Temp visit(AddExpression a) throws Exception
    {
        Temp t1 = visit(a.getLHS());
        Temp t2 = visit(a.getRHS());
        Temp result = currentFunction.getTemp(t1.getType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new BinaryOpAssignment(result,t1,BinaryOpAssignment.BinaryOp.ADD,t2));
        return result;
    }

	public Temp visit(EqualityExpression eq) throws Exception
    {
        Temp t1 = visit(eq.getLHS());
        Temp t2 = visit(eq.getRHS());
        Temp result = currentFunction.getTemp(new IRBooleanType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new BinaryOpAssignment(result,t1,BinaryOpAssignment.BinaryOp.EQ,t2));
        return result;
    }

	public Temp visit(LessThanExpression lt) throws Exception
    {
        Temp t1 = visit(lt.getLHS());
        Temp t2 = visit(lt.getRHS());
        Temp result = currentFunction.getTemp(new IRBooleanType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new BinaryOpAssignment(result,t1,BinaryOpAssignment.BinaryOp.LT,t2));
        return result;
    }

	public Temp visit(MultExpression m) throws Exception
    {
        Temp t1 = visit(m.getLHS());
        Temp t2 = visit(m.getRHS());
        Temp result = currentFunction.getTemp(t1.getType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new BinaryOpAssignment(result,t1,BinaryOpAssignment.BinaryOp.MULT,t2));
        return result;
    }

	public Temp visit(SubExpression s) throws Exception
    {
        Temp t1 = visit(s.getLHS());
        Temp t2 = visit(s.getRHS());
        Temp result = currentFunction.getTemp(t1.getType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new BinaryOpAssignment(result,t1,BinaryOpAssignment.BinaryOp.SUB,t2));
        return result;
    }

    public Temp visit(FunctionCall f) throws Exception
    {
        Temp t = null;
        String funcName = f.getID().getName();
        FunctionDeclaration fd = functionEnvironment.getInScope(funcName);
        Type type = fd.getSignature().getType();
        
        if (!(type instanceof VoidType))
        {
            t = currentFunction.getTemp(IRType.convertToIRType(type), Temp.Category.TEMP);
        }
        CallInstruction ci = new CallInstruction(t,funcName);
        
        int args = f.getArgumentCount();
        for (int i=0;i<args;i++)
        {
            Temp ti = visit(f.getArgumentAt(i));
            ci.addArgument(ti);
        }
        currentFunction.addInstruction(ci);
        return t;
    }

	public Temp visit(ArrayReference a) throws Exception
    {
        Temp arr = variableEnvironment.getInScope(a.getID().getName());
        Temp index = visit(a.getIndex());
        Temp result = currentFunction.getTemp(((IRArrayType)arr.getType()).getType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ArrayAssignment(arr,index,result,false));
        return result;
    }

	public Temp visit(Identifier i) throws Exception
    {
        return variableEnvironment.getInScope(i.getName());
    }

	public Temp visit(ParenthesizedExpression e) throws Exception
    {
        return visit(e.getExpression());
    }

	public Temp visit(BooleanLiteral b) throws Exception
    {
        Temp result = currentFunction.getTemp(new IRBooleanType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ConstantAssignment(result, b));
        return result;
    }

	public Temp visit(CharacterLiteral c) throws Exception
    {   
        Temp result = currentFunction.getTemp(new IRCharacterType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ConstantAssignment(result, c));
        return result;
    }

	public Temp visit(FloatLiteral f) throws Exception
    {
        Temp result = currentFunction.getTemp(new IRFloatType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ConstantAssignment(result, f));
        return result;
    }

	public Temp visit(IntegerLiteral i) throws Exception
    {
        Temp result = currentFunction.getTemp(new IRIntegerType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ConstantAssignment(result, i));
        return result;
    }

	public Temp visit(StringLiteral s) throws Exception
    {
        Temp result = currentFunction.getTemp(new IRStringType(), Temp.Category.TEMP);
        currentFunction.addInstruction(new ConstantAssignment(result, s));
        return result;
    }
    
    //NOT SURE IF THESE SHOULD BE USED

	public Temp visit(ArrayType a)
    {
        return null;
    }

	public Temp visit(BooleanType b)
    {
        return null;
    }

	public Temp visit(CharacterType c)
    {
        return null;
    }

	public Temp visit(FloatType f)
    {
        return null;
    }

	public Temp visit(StringType s)
    {
        return null;
    }

    public Temp visit(IntegerType i)
    {
        return null;
    }

	public Temp visit(VoidType v)
    {
        return null;
    }
	
}
