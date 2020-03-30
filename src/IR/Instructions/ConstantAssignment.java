package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class ConstantAssignment extends Assignment
{
    Temp result;
    Literal lit;
    
	public ConstantAssignment(Temp result, Literal lit)
    {
        this.result = result;
        this.lit = lit;
    }
    
    public String toString()
    {
        if(lit instanceof BooleanLiteral)
        {
            return result.toString() +" := "+ lit.value.toString().toUpperCase();
        }
        else if(lit instanceof CharacterLiteral)
        {
            return result.toString() +" := '"+ lit.value.toString() + "'";
        }
        else if(lit instanceof StringLiteral)
        {
            return result.toString() +" := \""+ lit.value.toString() + "\"";
        }
        else 
        {
            return result.toString() +" := "+ lit.value.toString();
        }
    }
}