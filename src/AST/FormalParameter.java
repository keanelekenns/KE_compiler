package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

public class FormalParameter extends ASTNode
{
	Type type;
    Identifier id;
    
	public FormalParameter (Type type, Identifier id)
	{
        this.type = type;
        this.id = id;
        this.setLine(id.getLine());
        this.setOffset(id.getOffset());
	}
    
    public Identifier getID()
    {
        //clone
        return id;
    }
    
    public Type getType()
    {
        //clone
        return type;
    }
    
    
    
}
