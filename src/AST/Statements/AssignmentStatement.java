package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class AssignmentStatement extends Statement
{
	Identifier	id;
	Expression	expr;
	
	public AssignmentStatement(Identifier id, Expression e)
	{
		this.id = id;
		this.expr = e;
        this.setLine(id.getLine());
        this.setOffset(id.getOffset());
	}
    
    public Identifier getID()
    {
        return id;
    }
    
    public Expression getExpression()
    {
        return expr;
    }
	
    
    
}
