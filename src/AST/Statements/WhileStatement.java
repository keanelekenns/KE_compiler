package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class WhileStatement extends Statement
{
	Expression expr;
	Block block;
    
	public WhileStatement(Expression e, Block b)
	{
        this.expr = e;
        this.block = b;
        this.setLine(expr.getLine());
        this.setOffset(expr.getOffset());
	}
    
    public Expression getExpression()
    {
        return expr;
    }
    
    public Block getBlock()
    {
        return block;
    }
	
    
    
}
