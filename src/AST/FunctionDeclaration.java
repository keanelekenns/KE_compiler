package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

import java.util.ArrayList;

public class FunctionDeclaration extends ASTNode
{
	ArrayList<FormalParameter>	parameters;
	FormalParameter signature;
    
	public FunctionDeclaration (FormalParameter sig)
	{
		parameters = new ArrayList<FormalParameter>();
        signature = sig;
        this.setLine(sig.getLine());
        this.setOffset(sig.getOffset());
	}
    
    public FormalParameter getSignature()
    {
        return signature;
    }
    
	public void addParameter(FormalParameter p)
	{	
		parameters.add(p);
	}
    
    public FormalParameter getParameterAt(int i)
    {
        //clone
        return parameters.get(i);
    }
    
    public int getParameterCount()
    {
        return parameters.size();
    }
    
    
    
}
