package IR;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;

import java.util.ArrayList;

public class IRProgram
{
    String name;
	ArrayList<IRFunction>	functions;
	
	public IRProgram(String name)
	{
        this.name = name;
		functions = new ArrayList<IRFunction>();
	}
	
	public void addFunction(IRFunction f)
	{
        functions.add(f);
	}
    
    public IRFunction getFunctionAt(int i)
    {
        return functions.get(i);
    }
    
    public int getFunctionCount()
    {
        return functions.size();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder(500);
        sb.append("PROG " + name +"\n");
        for (int i = 0; i < functions.size(); i++)
        {
            sb.append(functions.get(i).toString() + "\n");
        }
        return sb.toString();
    }
}
