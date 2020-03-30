package AST.Types;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import util.*;
import IR.*;

public class FloatType extends Type
{
	
	public FloatType(int line, int offset){
        this.setLine(line);
        this.setOffset(offset);
    }

    
    
    
    public String toString()
    {
        return "float";
    }
}
