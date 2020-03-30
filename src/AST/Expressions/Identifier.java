package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class Identifier extends Expression
{
	String	name;
	
	public Identifier (String name,int line, int offset)
	{
		this.name = name;
        this.setLine(line);
        this.setOffset(offset);
	}

    public String getName()
    {
        return name;
    }
    
    
    
}
