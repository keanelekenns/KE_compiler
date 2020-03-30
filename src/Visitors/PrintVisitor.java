package Visitors;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
public class PrintVisitor extends Visitor<Object>
{
    private int current_indentation = 0;
    
    private void indent()
    {
        for(int i = 0; i < current_indentation; i++)
        {
            System.out.print("    ");
        }
    }
    
    public Object visit(Program p) throws Exception
	{
		int functionCount = p.getFunctionCount();
		
		for (int i=0;i<functionCount;i++)
		{
			visit(p.getFunctionAt(i));
		}
		return null;
	}
    
	public Object visit(Function f) throws Exception
    {
        visit(f.getFuncDecl());
        visit(f.getFuncBody());
        return null;
    }
    
    public Object visit(FunctionDeclaration fd) throws Exception
    {
        visit(fd.getSignature());
        System.out.print(" (");
        int params = fd.getParameterCount();
        if (params > 0){
            visit(fd.getParameterAt(0));
            for (int i=1;i<params;i++)
            {
                System.out.print(", ");
                visit(fd.getParameterAt(i));
            }
        }
        System.out.println(")");
        return null;
    }
    
    public Object visit(FunctionBody fb) throws Exception
    {
        System.out.println("{");
        current_indentation++;
        
        int varDeclCount = fb.getVarDeclCount();
		
		for (int i=0;i<varDeclCount;i++)
		{
            indent();
			visit(fb.getVarDeclAt(i));
		}
        
        if(varDeclCount>0)
        {
            System.out.println();
        }
        
        int stmtCount = fb.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
            indent();
			visit(fb.getStatementAt(i));
		}
        current_indentation--;
        System.out.println("}\n");
        return null;
    }
    
	public Object visit(FormalParameter p) throws Exception
    {
        visit(p.getType());
        System.out.print(" ");
        visit(p.getID());
        return null;
    }

	public Object visit(VariableDeclaration vd) throws Exception
    {
        visit(vd.getType());
        System.out.print(" ");
        visit(vd.getID());
        System.out.println(";");
        return null;
    }
    
    public Object visit(EmptyStatement s) throws Exception
    {
        System.out.println(";");
        return null;
    }
    
    public Object visit(AssignmentStatement a) throws Exception
    {
        visit(a.getID());
		System.out.print("=");
		visit(a.getExpression());
		System.out.println(";");
        return null;
    }

	public Object visit(ArrayAssignmentStatement aa) throws Exception
    {
        visit(aa.getArrayReference());
		System.out.print("=");
		visit(aa.getExpression());
		System.out.println(";");
        return null;
    }

	public Object visit(ExpressionStatement e) throws Exception
    {
        visit(e.getExpression());
		System.out.println(";");
        return null;
    }

	public Object visit(IfElseStatement ie) throws Exception
    {
        System.out.print("if (");
        visit(ie.getExpression());
        System.out.println(")");
        visit(ie.getIfBlock());
        if(ie.getElseBlock() != null)
        {
            indent();
            System.out.println("else");
            visit(ie.getElseBlock());
        }
        return null;
    }

	public Object visit(PrintlnStatement p) throws Exception
    {
        System.out.print("println ");
        visit(p.getExpression());
        System.out.println(";");
        return null;
    }

	public Object visit(PrintStatement p) throws Exception
    {
        System.out.print("print ");
        visit(p.getExpression());
        System.out.println(";");
        return null;
    }

	public Object visit(ReturnStatement r) throws Exception
    {
        System.out.print("return");
        if(r.getExpression() != null)
        {
            System.out.print(" ");
            visit(r.getExpression());
        }
        System.out.println(";");
        return null;
    }

	public Object visit(WhileStatement w) throws Exception
    {
        System.out.print("while (");
        visit(w.getExpression());
        System.out.println(")");
        visit(w.getBlock());
        return null;
    }

    public Object visit(Block b) throws Exception
    {
        indent();
        System.out.println("{");
        current_indentation++;
        int stmtCount = b.getStatementCount();
        
		for (int i=0;i<stmtCount;i++)
		{
            indent();
			visit(b.getStatementAt(i));
		}
        current_indentation--;
        indent();
        System.out.println("}");
        return null;
    }

	public Object visit(AddExpression a) throws Exception
    {
        visit(a.getLHS());
        System.out.print("+");
        visit(a.getRHS());
        return null;
    }

	public Object visit(EqualityExpression eq) throws Exception
    {
        visit(eq.getLHS());
        System.out.print("==");
        visit(eq.getRHS());
        return null;
    }

	public Object visit(LessThanExpression lt) throws Exception
    {
        visit(lt.getLHS());
        System.out.print("<");
        visit(lt.getRHS());
        return null;
    }

	public Object visit(MultExpression m) throws Exception
    {
        visit(m.getLHS());
        System.out.print("*");
        visit(m.getRHS());
        return null;
    }

	public Object visit(SubExpression s) throws Exception
    {
        visit(s.getLHS());
        System.out.print("-");
        visit(s.getRHS());
        return null;
    }

    public Object visit(FunctionCall f) throws Exception
    {
        visit(f.getID());
        System.out.print("(");
        int args = f.getArgumentCount();
        if (args > 0){
            visit(f.getArgumentAt(0));
            for (int i=1;i<args;i++)
            {
                System.out.print(", ");
                visit(f.getArgumentAt(i));
            }
        }
        System.out.print(")");
        return null;
    }

	public Object visit(ArrayReference a) throws Exception
    {
        visit(a.getID());
        System.out.print("[");
        visit(a.getIndex());
        System.out.print("]");
        return null;
    }

	public Object visit(Identifier i) throws Exception
    {
        System.out.print(i.getName());
        return null;
    }

	public Object visit(ParenthesizedExpression e) throws Exception
    {
        System.out.print("(");
        visit(e.getExpression());
        System.out.print(")");
        return null;
    }

	public Object visit(BooleanLiteral b) throws Exception
    {
        System.out.print(b.value.toString());
        return null;
    }

	public Object visit(CharacterLiteral c) throws Exception
    {   
        System.out.print("'");
        System.out.print(c.value.toString());
        System.out.print("'");
        return null;
    }

	public Object visit(FloatLiteral f) throws Exception
    {
        System.out.print(f.value.toString());
        return null;
    }

	public Object visit(IntegerLiteral i) throws Exception
    {
        System.out.print(i.value.toString());
        return null;
    }

	public Object visit(StringLiteral s) throws Exception
    {
        System.out.print("\"");
        System.out.print(s.value);
        System.out.print("\"");
        return null;
    }

	public Object visit(ArrayType a) throws Exception
    {
        visit(a.getType());
        System.out.print("[");
        visit(a.getSize());
        System.out.print("]");
        return null;
    }

	public Object visit(BooleanType b)
    {
        System.out.print("boolean");
        return null;
    }

	public Object visit(CharacterType c)
    {
        System.out.print("char");
        return null;
    }

	public Object visit(FloatType f)
    {
        System.out.print("float");
        return null;
    }

	public Object visit(StringType s)
    {
        System.out.print("string");
        return null;
    }

    public Object visit(IntegerType i)
    {
        System.out.print("int");
        return null;
    }

	public Object visit(VoidType v)
    {
        System.out.print("void");
        return null;
    }
	
}
