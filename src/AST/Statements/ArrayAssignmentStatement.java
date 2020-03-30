package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class ArrayAssignmentStatement extends Statement
{
	ArrayReference ar;
	Expression	expr;
	
	public ArrayAssignmentStatement(ArrayReference ar, Expression e)
	{
		this.ar = ar;
		this.expr = e;
        this.setLine(ar.getLine());
        this.setOffset(ar.getOffset());
	}
    
    public ArrayReference getArrayReference()
    {
        return ar;
    }
    
    public Expression getExpression()
    {
        return expr;
    }
	
    
    
}
