package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


import java.util.ArrayList;

public class FunctionCall extends Expression
{
    ArrayList<Expression>	arguments;
    Identifier id;
    
    public FunctionCall(Identifier id){
        arguments = new ArrayList<Expression>();
        this.id = id;
        this.setLine(id.getLine());
        this.setOffset(id.getOffset());
    }
    
    public Identifier getID()
    {
        return id;
    }
    
    public void addArgument(Expression e)
	{	
		arguments.add(e);
	}
    
    public Expression getArgumentAt(int i)
    {
        return arguments.get(i);
    }
    
    public int getArgumentCount()
    {
        return arguments.size();
    }
    
    
    
}