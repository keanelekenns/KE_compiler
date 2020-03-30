package AST.Statements;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Types.*;
import util.*;
import IR.*;

public class IfElseStatement extends Statement
{
	Expression expr;
	Block if_block, else_block;
    
	public IfElseStatement(Expression e, Block if_block)
	{
        this.expr = e;
        this.if_block = if_block;
        this.setLine(e.getLine());
        this.setOffset(e.getOffset());
	}
    
    public Expression getExpression()
    {
        return expr;
    }
    
    public Block getIfBlock()
    {
        return if_block;
    }
    
	public void setElseBlock(Block else_block)
	{
        this.else_block = else_block;
	}
    
    public Block getElseBlock()
    {
        return else_block;
    }
    
    
    
}
