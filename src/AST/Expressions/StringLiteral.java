package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class StringLiteral extends Literal<String>
{
	public StringLiteral (String value, int line, int offset)
	{
		super(value, line, offset);
	}
    
    
    
}
