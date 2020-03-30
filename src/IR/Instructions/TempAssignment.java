package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class TempAssignment extends Assignment
{
    Temp lhs;
    Temp rhs;
    
	public TempAssignment(Temp lhs, Temp rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    public String toString()
    {
        return lhs.toString() + " := " + rhs.toString();
    }
}