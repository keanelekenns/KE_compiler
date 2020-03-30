package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;
import util.*;

public class UnaryOpAssignment extends Assignment
{
	public enum UnaryOp 
    {
        NEG{public String toString(){ return "-";}}, 
        NOT{public String toString(){ return "!";}}, 
        CONV{public String toString(){ return "2";}}
    }
    
    Temp lhs;
    Temp t;
    UnaryOp operation;
    
    public UnaryOpAssignment(Temp lhs, UnaryOp operation, Temp t)
    {
        try
        {
            testOp(lhs.getType(), operation, t.getType());
        }
        catch(IllegalOpException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        this.lhs = lhs;
        this.t = t;
        this.operation = operation;
    }
    
    private void testOp(IRType lhs, UnaryOp op, IRType t) throws IllegalOpException
    {
        //Refer to table 2 of IR specification
        if(lhs instanceof IRStringType || t instanceof IRStringType ||
            lhs instanceof IRArrayType || t instanceof IRArrayType ||
            lhs instanceof IRVoidType || t instanceof IRVoidType)
        {
            throw new IllegalOpException();
        }
        if((op.equals(UnaryOp.NEG) || op.equals(UnaryOp.NOT)) && !(lhs.equals(t)))
        {
            throw new IllegalOpException();
        }
        if(op.equals(UnaryOp.NEG) && !(t instanceof IRIntegerType || t instanceof IRFloatType))
        {
            throw new IllegalOpException();
        }
        if(op.equals(UnaryOp.NOT) && !(t instanceof IRBooleanType || t instanceof IRIntegerType))
        {
            throw new IllegalOpException();
        }
        if(op.equals(UnaryOp.CONV) && !(lhs.equals(t)))
        {
            if(lhs instanceof IRBooleanType || t instanceof IRBooleanType)
            {
                throw new IllegalOpException();
            }
            if(t instanceof IRCharacterType && lhs instanceof IRFloatType)
            {
                throw new IllegalOpException();
            }
            if(t instanceof IRFloatType && lhs instanceof IRCharacterType)
            {
                throw new IllegalOpException();
            }
        }
    }
    
    public String toString()
    {
        if(operation.equals(UnaryOp.CONV))
        {
            return lhs.toString()+" := "+ t.getType().toString() + 
                operation.toString() + lhs.getType().toString()+ " " + t.toString();
        }
        else
        {
            return lhs.toString()+" := "+ t.getType().toString() + operation.toString()+ " " + t.toString();
        }
    }
}