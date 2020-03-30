package IR.Instructions;

import AST.Expressions.*;
import IR.*;
import IR.IRTypes.*;
import util.*;

public class BinaryOpAssignment extends Assignment
{
	public enum BinaryOp 
    {
        ADD{public String toString(){ return "+";}}, 
        SUB{public String toString(){ return "-";}}, 
        MULT{public String toString(){ return "*";}},
        DIV{public String toString(){ return "/";}}, 
        REM{public String toString(){ return "rem";}}, 
        LT{public String toString(){ return "<";}}, 
        LE{public String toString(){ return "<=";}}, 
        EQ{public String toString(){ return "==";}}, 
        NE{public String toString(){ return "!=";}}, 
        GE{public String toString(){ return ">=";}}, 
        GT{public String toString(){ return ">";}}
    }
    
    Temp lhs;
    Temp t1;
    BinaryOp operation;
    Temp t2;
    
    public BinaryOpAssignment(Temp lhs, Temp t1, BinaryOp operation, Temp t2)
    {
        try
        {
            testOp(lhs.getType(), t1.getType(), operation, t2.getType());
        }
        catch(IllegalOpException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        this.lhs = lhs;
        this.t1 = t1;
        this.operation = operation;
        this.t2 = t2;
    }
    
    private void testOp(IRType lhs, IRType t1, BinaryOp op, IRType t2) throws IllegalOpException
    {
        //Refer to table 3 of IR specification
        if(lhs instanceof IRArrayType || t1 instanceof IRArrayType ||
            lhs instanceof IRVoidType || t1 instanceof IRVoidType)
        {
            throw new IllegalOpException();
        }
        if(!t1.equals(t2))
        {
            throw new IllegalOpException();
        }
        if(op.equals(BinaryOp.ADD) || op.equals(BinaryOp.SUB) ||
                op.equals(BinaryOp.MULT) || op.equals(BinaryOp.DIV) || op.equals(BinaryOp.REM))
        {
            if(t1 instanceof IRBooleanType)
            {
                throw new IllegalOpException();
            }
            if(t1 instanceof IRStringType && !(op.equals(BinaryOp.ADD)))
            {
                throw new IllegalOpException();
            }
            if(!lhs.equals(t1))
            {
                throw new IllegalOpException();
            }
        }
        if(op.equals(BinaryOp.LT) || op.equals(BinaryOp.LE) ||
                op.equals(BinaryOp.EQ) || op.equals(BinaryOp.NE) ||
                op.equals(BinaryOp.GE) || op.equals(BinaryOp.GT))
        {
            if(!(lhs instanceof IRBooleanType))
            {
                throw new IllegalOpException();
            }
            if((t1 instanceof IRBooleanType) && !(op.equals(BinaryOp.EQ) || op.equals(BinaryOp.NE)))
            {
                throw new IllegalOpException();
            }
        }
    }
    
    public String toString()
    {
        return lhs.toString()+" := "+ t1.toString() +" "+ t1.getType().toString() +operation.toString()+ " " + t2.toString();
    }
}