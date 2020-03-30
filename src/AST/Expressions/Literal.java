package AST.Expressions;

import Visitors.*;
import AST.*;
import AST.Statements.*;
import AST.Types.*;
import util.*;
import IR.*;


public abstract class Literal<T> extends Expression
{
    public T value;
    
    public Literal(T value,int line,int offset)
	{
		this.value = value;
        this.setLine(line);
        this.setOffset(offset);
	}
}
