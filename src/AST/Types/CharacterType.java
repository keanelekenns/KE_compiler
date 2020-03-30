package AST.Types;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import util.*;
import IR.*;

public class CharacterType extends Type
{
	
	public CharacterType(int line, int offset)
    {
        this.setLine(line);
        this.setOffset(offset);
    }
    
    
    
    
    public String toString()
    {
        return "char";
    }
}
