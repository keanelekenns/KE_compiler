package IR.IRTypes;

import AST.Types.*;

public abstract class IRType
{
    public boolean equals(IRType t)
    {
        return (this.getClass() == t.getClass());
    } 
    
    public static IRType convertToIRType(Type t)
    {
        if(t instanceof VoidType)
        {
            return new IRVoidType();
        }
        else if (t instanceof BooleanType)
        {
            return new IRBooleanType();
        }
        else if (t instanceof StringType)
        {
            return new IRStringType();
        }
        else if (t instanceof IntegerType)
        {
            return new IRIntegerType();
        }
        else if (t instanceof CharacterType)
        {
            return new IRCharacterType();
        }
        else if (t instanceof FloatType)
        {
            return new IRFloatType();
        }
        else //ArrayType
        {
            return new IRArrayType(((ArrayType)t).getSize().value, convertToIRType(((ArrayType)t).getType()));
        }
    }
}

