package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

public class VariableDeclaration extends ASTNode
{
	Type type;
    Identifier id;
    
	public VariableDeclaration (Type t, Identifier id)
	{
        type = t;
        this.id = id;
        this.setLine(id.getLine());
        this.setOffset(id.getOffset());
	}
    
    public Type getType()
    {
        return type;
    }
    
    public Identifier getID()
    {
        return id;
    }
    
    
    
}
