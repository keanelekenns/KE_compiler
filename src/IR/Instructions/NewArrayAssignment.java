package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class NewArrayAssignment extends Assignment
{
    Temp t;
    IRType type;
    int size;
    
	public NewArrayAssignment(Temp t, IRType type, int size)
    {
        this.t = t;
        this.type = type;
        this.size = size;
    }
    
    public String toString()
    {
        return t.toString() + " := NEWARRAY " + type.toString() + " " + size;
    }
}