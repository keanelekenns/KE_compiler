package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class ArrayReference extends Expression
{
    Identifier id;
    Expression index;
    
    public ArrayReference(Identifier id, Expression e){
        this.id = id;
        index = e;
        this.setLine(id.getLine());
        this.setOffset(id.getOffset());
    }
    
    public Identifier getID()
    {
        return id;
    }
    
    public Expression getIndex()
    {
        return index;
    }
}
