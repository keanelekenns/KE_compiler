package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;

public class ArrayAssignment extends Assignment
{
    Temp arr;
    Temp index;
    Temp operand;
    boolean operandOnRight;
    
	public ArrayAssignment(Temp arr, Temp index, Temp operand, boolean operandOnRight)
    {
        this.operand = operand;
        this.arr = arr;
        this.index = index;
        this.operandOnRight = operandOnRight;
    }
    
    public String toString()
    {
        if(operandOnRight)
        {
            return arr.toString() +"["+ index.toString() + "] := " + operand.toString();
        }
        else
        {
            return operand.toString() + " := "+ arr.toString() +"["+ index.toString() +"]";
        }
    }
}