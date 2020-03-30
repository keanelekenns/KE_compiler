package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class PrintStatement extends Statement
{
	Expression expr;
	
	public PrintStatement(Expression e)
	{
        this.expr = e;
        this.setLine(expr.getLine());
        this.setOffset(expr.getOffset());
	}
    
    public Expression getExpression()
    {
        return expr;
    }
	
    
    
}
