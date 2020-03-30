package AST.Types;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import util.*;
import IR.*;

public class ArrayType extends Type
{
	IntegerLiteral size;
    Type type;
    
	public ArrayType(IntegerLiteral size, Type type){
        this.size = size;
        this.type = type;
        this.setLine(type.getLine());
        this.setOffset(type.getOffset());
    }
    
    public Type getType()
    {
        return type;
    }
    
    public IntegerLiteral getSize()
    {
        return size;
    }
    
    @Override
    public boolean equals(Type t)
    {   
        if(!(t instanceof ArrayType))
        {
            return false;
        }
        else if(this.type.equals(((ArrayType)t).type) && (this.size.value == ((ArrayType)t).size.value))
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        return type.toString() + " array of size " + size.value.toString();
    }
        
    
    
    
}
