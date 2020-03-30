package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

import java.util.ArrayList;

public class Block extends ASTNode
{
    ArrayList<Statement>    statements;
    
	public Block ()
	{
        statements = new ArrayList<Statement>();
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
