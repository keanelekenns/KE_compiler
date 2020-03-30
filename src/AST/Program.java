package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

import java.util.ArrayList;

public class Program extends ASTNode
{
	ArrayList<Function>	functions;
	
	public Program()
	{
		functions = new ArrayList<Function>();
        this.setLine(0);
        this.setOffset(0);
	}
	
	public void addFunction(Function f)
	{	
        functions.add(f);
	}
    
    public Function getFunctionAt(int i)
    {
        return functions.get(i);
    }
    
    public int getFunctionCount()
    {
        return functions.size();
    }
}
