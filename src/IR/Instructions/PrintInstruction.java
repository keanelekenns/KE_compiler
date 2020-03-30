package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class PrintInstruction extends Instruction
{
    Temp    expression;
    boolean println;
    
	public PrintInstruction(Temp expression, boolean println)
    {
        this.expression = expression;
        this.println = println;
    }
    
    public String toString()
    {
        if(println)
        {
           return "PRINTLN" + expression.getType().toString() + " " + expression.toString(); 
        }
        else
        {
            return "PRINT" + expression.getType().toString() + " " + expression.toString(); 
        }
    }
}