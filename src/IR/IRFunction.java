package IR;

import Visitors.*;
import AST.Expressions.*;
import AST.Statements.*;
import IR.IRTypes.*;
import IR.Instructions.*;
import util.*;
import java.util.*;

public class IRFunction 
{    
    String name;
    IRType returnType;
    int parameterCount = 0;
    int labelCount = 0;
    ArrayList<Temp> temps;
    ArrayList<Instruction> instructions;
    TempFactory tempFactory;
    
    private class TempFactory
    {
        static final int MAX_TEMPS = 65536; //Max number of temporaries allowed in JVM
        private int next = 0;
        
        public Temp getTemp(IRType t, Temp.Category c) throws MaxTempCountException
        {
            if (next == MAX_TEMPS)
            {
                throw new MaxTempCountException();
            }
            
            return new Temp(next++, t, c);
        }
    } 
    
    public IRFunction(String name, IRType returnType)
    {
        this.name = name;
        this.returnType = returnType;
        temps = new ArrayList<Temp>();
        instructions = new ArrayList<Instruction>();
        tempFactory = new TempFactory();
    }
    
    public int getLabelNumber()
    {
        return labelCount++;
    }
    
    public Temp getTemp(IRType t, Temp.Category c)
    {
        Temp temp = null;
        try
        {
            temp = tempFactory.getTemp(t, c);
        }
        catch(MaxTempCountException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        
        if(c.equals(Temp.Category.PARAM))
        {
            parameterCount++;
        }
        
        temps.add(temp);
        return temp;
    }
    
    public String getName()
    {
        return name;
    }
    
    public IRType getReturnType()
    {
        return returnType;
    }
    
    public int getParameterCount()
    {
        return parameterCount;
    }
    
    public int getTempCount()
    {
        return temps.size();
    }
    
    public Temp getTempAt(int i)
    {
        return temps.get(i);
    }
    
    public int getInstructionCount()
    {
        return instructions.size();
    }
    
    public void addInstruction(Instruction i)
    {
        instructions.add(i);
    }
    
    public Instruction getInstructionAt(int i)
    {
        return instructions.get(i);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder(100);
        sb.append("FUNC ").append(name).append(" (");
        for(int i = 0; i < parameterCount; i++)
        {
            sb.append(temps.get(i).getType().toString());
        }
        
        sb.append(")").append(returnType.toString()).append("\n{\n");
        
        for(int i = 0; i < temps.size(); i++)
        {
            sb.append("    ").append("TEMP ").append(temps.get(i).getNumber()).append(":").append(temps.get(i).getType().toString()).append(";\n");
        }
        
        for(int i = 0; i < instructions.size(); i++)
        {
            sb.append("    ").append(instructions.get(i).toString()).append(";\n");
        }
        
        //Jasmin requires a return statement on void functions, even though we don't in our language
        if(returnType instanceof IRVoidType && ((instructions.size() == 0) || !(instructions.get(instructions.size() - 1) instanceof ReturnInstruction)))
        {
            sb.append("    RETURN;\n");
        }
        
        sb.append("}\n");
        
        return sb.toString();
    }

}
