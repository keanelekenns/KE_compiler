package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class ReturnStatement extends Statement
{
	Expression expr;
	
	public ReturnStatement(int line, int offset)
    {
        this.setLine(line);
        this.setOffset(offset);
    }
	
    public void setReturnExpression(Expression e)
	{
        this.expr = e;
	}
    
    public Expression getExpression()
    {
        return expr;
    }
    
    
    
}
