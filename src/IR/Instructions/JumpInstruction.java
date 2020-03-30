package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class JumpInstruction extends Instruction
{
	Temp condition;
    int labelNumber;
    
    public JumpInstruction(Temp condition, int labelNumber)
    {
        this.condition = condition;
        this. labelNumber = labelNumber;
    }
    
    public String toString()
    {
        if(condition != null)
        {
          return "IF "+condition.toString()+" GOTO L"+labelNumber;  
        }
        else
        {
            return "GOTO L"+labelNumber;
        }
    }
}