package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class ExpressionStatement extends Statement
{
	Expression expr;
	
	public ExpressionStatement(Expression e)
	{
        this.expr = e;
        this.setLine(e.getLine());
        this.setOffset(e.getOffset());
	}
    
    public Expression getExpression()
    {
        return expr;
    }
	
    
    
}
