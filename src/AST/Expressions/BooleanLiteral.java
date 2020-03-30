package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class BooleanLiteral extends Literal<Boolean>
{
	public BooleanLiteral (Boolean value, int line, int offset)
	{
		super(value, line, offset);
	}
    
    
    
}
