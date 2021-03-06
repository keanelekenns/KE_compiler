package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class MultExpression extends Expression
{
	Expression lhs;
	Expression rhs;
	
	public MultExpression(Expression lhs, Expression rhs)
	{
		this.lhs = lhs;
		this.rhs = rhs;
        this.setLine(rhs.getLine());
        this.setOffset(rhs.getOffset());
	}
	
    public Expression getLHS()
    {
        return lhs;
    }
    
    public Expression getRHS()
    {
        return rhs;
    }
    
    
    
}
