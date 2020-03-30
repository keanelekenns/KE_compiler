
package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public class CharacterLiteral extends Literal<Character>
{
	public CharacterLiteral (Character value, int line, int offset)
	{
		super(value, line, offset);
	}
    
    
    
}
