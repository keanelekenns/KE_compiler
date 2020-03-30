package AST.Types;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import util.*;
import IR.*;

public class VoidType extends Type
{
	
	public VoidType(int line, int offset)
    {
        this.setLine(line);
        this.setOffset(offset);
    }
    
    
    
    
    public String toString()
    {
        return "void";
    }
}
