package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class IntegerLiteral extends Literal<Integer>
{
	public IntegerLiteral (Integer value, int line, int offset)
	{
		super(value, line, offset);
	}
    
    
    
}
