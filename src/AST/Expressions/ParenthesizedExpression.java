package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class ParenthesizedExpression extends Expression
{
    Expression expr;
    
    public ParenthesizedExpression(Expression e)
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
