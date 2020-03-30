package AST.Types;

import Visitors.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import util.*;
import IR.*;

public abstract class Type extends ASTNode
{    
    public boolean equals(Type t)
    {
        return (this.getClass() == t.getClass());
    }
}

