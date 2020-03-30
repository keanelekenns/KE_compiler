package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class PrintlnStatement extends Statement
{
	Expression expr;
	
	public PrintlnStatement(Expression e)
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
