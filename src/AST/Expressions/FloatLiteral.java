package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class FloatLiteral extends Literal<Float>
{
	public FloatLiteral (Float value, int line, int offset)
	{
		super(value, line, offset);
	}
    
    
    
}
