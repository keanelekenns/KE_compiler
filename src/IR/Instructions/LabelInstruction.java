package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class LabelInstruction extends Instruction
{
    int labelNumber;
    
	public LabelInstruction(int labelNumber)
    {
        this.labelNumber = labelNumber;
    }
    
    public String toString()
    {
        return "L"+labelNumber+":";
    }
}