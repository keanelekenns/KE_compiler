package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class ReturnInstruction extends Instruction
{
    Temp expression;
    
	public ReturnInstruction(Temp expression)
    {
        this.expression = expression;
    }
    
    public String toString()
    {
        if(expression != null)
        {
            return "RETURN " + expression.toString();
        }
        else
        {
            return "RETURN";
        }
    }
}