package AST;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;

public class Function extends ASTNode// implements Cloneable
{
	FunctionDeclaration     fd;
    FunctionBody            fb;
	
	public Function (FunctionDeclaration fd, FunctionBody fb)
	{
		this.fd = fd;
        this.fb = fb;
        
        this.setLine(fd.getLine());
        this.setOffset(fd.getOffset());
	}
    
    public FunctionDeclaration getFuncDecl()
    {
         return fd;
    }
    
    public FunctionBody getFuncBody()
    {
         return fb;
    }
    
    
    
}
