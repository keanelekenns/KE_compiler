package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

import java.util.ArrayList;

public class FunctionBody extends ASTNode
{
	ArrayList<VariableDeclaration>	varDecls;
    ArrayList<Statement>        	statements;
    
	public FunctionBody ()
	{
		varDecls = new ArrayList<VariableDeclaration>();
        statements = new ArrayList<Statement>();
	}
    
    public void addVariableDeclaration(VariableDeclaration vd)
	{	
		varDecls.add(vd);
	}
    
    public VariableDeclaration getVarDeclAt(int i)
    {
        return varDecls.get(i);
    }
    
    public int getVarDeclCount()
    {
        return varDecls.size();
    }
    
	public void addStatement(Statement s)
	{	
		statements.add(s);
	}
    
    public Statement getStatementAt(int i)
    {
        return statements.get(i);
    }
    
    public int getStatementCount()
    {
        return statements.size();
    }
    
    
    
}
