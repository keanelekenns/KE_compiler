package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;
import java.util.*;

public class CallInstruction extends Instruction
{
	Temp lhs;
    ArrayList<Temp> arguments;
    String name;
    
	public CallInstruction(Temp lhs, String name)
    {
        this.lhs = lhs;
        this.name = name;
        arguments = new ArrayList<Temp>();
    }
    
    public void addArgument(Temp arg)
    {
        arguments.add(arg);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arguments.size(); i++)
        {
            sb.append(arguments.get(i).toString());
        }
        
        if(lhs != null)
        {
            return lhs.toString() + " := CALL " + name + "(" + sb.toString() + ")";
        }
        else
        {
            return "CALL " + name + "(" + sb.toString() + ")";
        }
    }
}