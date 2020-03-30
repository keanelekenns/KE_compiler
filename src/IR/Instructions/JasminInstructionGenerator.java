package IR.Instructions;

import java.io.*;
import IR.*;
import IR.IRTypes.*;
import AST.Expressions.*;
import java.util.*;

public class JasminInstructionGenerator 
{
    int currentLabel;
    String programName;
    
	public JasminInstructionGenerator(String programName)
    {
        this.programName = programName;
    }
    
    private int getLabel()
    {
        return currentLabel++;
    }
    
    public String IRTypeToJasminString(IRType t)
    {
        if(t instanceof IRStringType)
        {
            return "Ljava/lang/String;";
        }
        else if(t instanceof IRArrayType)
        {
            if(((IRArrayType)t).getType() instanceof IRStringType)
            {
                return "[Ljava/lang/String;";
            }
            else
            {
                return "["+ ((IRArrayType)t).getType().toString();
            }
        }
        else
        {
            return t.toString();
        }
    }
    
    public String generateInstruction(Instruction instruction)
    {
        if(instruction instanceof Assignment)
        {return generateInstruction((Assignment)instruction);}
        else if(instruction instanceof CallInstruction)
        {return generateInstruction((CallInstruction)instruction);}
        else if(instruction instanceof JumpInstruction)
        {return generateInstruction((JumpInstruction)instruction);}
        else if(instruction instanceof LabelInstruction)
        {return generateInstruction((LabelInstruction)instruction);}
        else if(instruction instanceof PrintInstruction)
        {return generateInstruction((PrintInstruction)instruction);}
        else {return generateInstruction((ReturnInstruction)instruction);}
    }
    
    private String generateInstruction(Assignment instruction)
    {
        if(instruction instanceof ArrayAssignment)
        {return generateInstruction((ArrayAssignment)instruction);}
        else if(instruction instanceof BinaryOpAssignment)
        {return generateInstruction((BinaryOpAssignment)instruction);}
        else if(instruction instanceof ConstantAssignment)
        {return generateInstruction((ConstantAssignment)instruction);}
        else if(instruction instanceof NewArrayAssignment)
        {return generateInstruction((NewArrayAssignment)instruction);}
        else if(instruction instanceof TempAssignment)
        {return generateInstruction((TempAssignment)instruction);}
        else {return generateInstruction((UnaryOpAssignment)instruction);}
    }
    
    private String generateInstruction(ArrayAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp arr = instruction.arr;
        Temp index = instruction.index;
        Temp operand = instruction.operand;
        sb.append("    aload " + arr.getNumber()+"\n");
        sb.append("    iload " + index.getNumber()+"\n");
        if(instruction.operandOnRight)
        {
            if(operand.getType() instanceof IRStringType)
            {
                sb.append("    aload "+ operand.getNumber()+"\n");
                sb.append("    aastore\n");
            }
            else if(operand.getType() instanceof IRFloatType)
            {
                sb.append("    fload "+ operand.getNumber()+"\n");
                sb.append("    fastore\n");
            }
            else if(operand.getType() instanceof IRCharacterType)
            {
                sb.append("    iload "+ operand.getNumber()+"\n");
                sb.append("    castore\n");
            }
            else if(operand.getType() instanceof IRBooleanType)
            {
                sb.append("    iload "+ operand.getNumber()+"\n");
                sb.append("    bastore\n");
            }
            else
            {
                sb.append("    iload "+ operand.getNumber()+"\n");
                sb.append("    iastore\n");
            }
        }
        else
        {
            if(operand.getType() instanceof IRStringType)
            {
                sb.append("    aaload\n");
                sb.append("    astore "+ operand.getNumber()+"\n");
            }
            else if(operand.getType() instanceof IRFloatType)
            {
                sb.append("    faload\n");
                sb.append("    fstore "+ operand.getNumber()+"\n");
            }
            else if(operand.getType() instanceof IRCharacterType)
            {
                sb.append("    caload\n");
                sb.append("    istore "+ operand.getNumber()+"\n");
            }
            else if(operand.getType() instanceof IRBooleanType)
            {
                sb.append("    baload\n");
                sb.append("    istore "+ operand.getNumber()+"\n");
            }
            else
            {
                sb.append("    iaload\n");
                sb.append("    istore "+ operand.getNumber()+"\n");
            }
        }
        return sb.toString();
    }
    
    private String generateInstruction(BinaryOpAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp t1 = instruction.t1;
        Temp t2 = instruction.t2;
        Temp lhs = instruction.lhs;
        BinaryOpAssignment.BinaryOp operation = instruction.operation;
        if(operation.equals(BinaryOpAssignment.BinaryOp.ADD))
        {
            if(t1.getType() instanceof IRStringType)
            {
                sb.append("    new java/lang/StringBuilder\n");
                sb.append("    dup\n");
                sb.append("    invokespecial java/lang/StringBuilder/<init>()V\n");
                sb.append("    aload "+t1.getNumber()+"\n");
                sb.append("    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;\n");
                sb.append("    aload "+t2.getNumber()+"\n");
                sb.append("    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;\n");
                sb.append("    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;\n");
                sb.append("    astore "+lhs.getNumber()+"\n");
            }
            else if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    fadd\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    iadd\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(BinaryOpAssignment.BinaryOp.SUB))
        {
            if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    fsub\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    isub\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(BinaryOpAssignment.BinaryOp.MULT))
        {
            if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    fmul\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    imul\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(BinaryOpAssignment.BinaryOp.DIV))
        {
            if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    fdiv\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    idiv\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(BinaryOpAssignment.BinaryOp.REM))
        {
            if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    frem\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    irem\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else //COMPARISON
        {
            int firstLabel = getLabel();
            int secondLabel = getLabel();
            if(t1.getType() instanceof IRStringType)
            {
                sb.append("    aload " + t1.getNumber()+"\n");
                sb.append("    aload " + t2.getNumber()+"\n");
                sb.append("    invokevirtual java/lang/String.compareTo(Ljava/lang/String;)I\n");
            }
            else if(t1.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + t1.getNumber()+"\n");
                sb.append("    fload " + t2.getNumber()+"\n");
                sb.append("    fcmpl\n");
            }
            else
            {
                sb.append("    iload " + t1.getNumber()+"\n");
                sb.append("    iload " + t2.getNumber()+"\n");
                sb.append("    isub\n");
            }
            
            if(operation.equals(BinaryOpAssignment.BinaryOp.LT))
            {
                sb.append("    iflt L_"+firstLabel+"\n");
            }
            else if(operation.equals(BinaryOpAssignment.BinaryOp.LE))
            {
                sb.append("    ifle L_"+firstLabel+"\n");
            }
            else if(operation.equals(BinaryOpAssignment.BinaryOp.EQ))
            {
                sb.append("    ifeq L_"+firstLabel+"\n");
            }
            else if(operation.equals(BinaryOpAssignment.BinaryOp.NE))
            {
                sb.append("    ifne L_"+firstLabel+"\n");
            }
            else if(operation.equals(BinaryOpAssignment.BinaryOp.GE))
            {
                sb.append("    ifge L_"+firstLabel+"\n");
            }
            else if(operation.equals(BinaryOpAssignment.BinaryOp.GT))
            {
                sb.append("    ifgt L_"+firstLabel+"\n");
            }
            sb.append("    ldc 0\n");
            sb.append("    goto L_" +secondLabel+"\n");
            sb.append("L_"+firstLabel+":\n");
            sb.append("    ldc 1\n");
            sb.append("L_"+secondLabel+":\n");
            sb.append("    istore " + lhs.getNumber() + "\n");
        }
        return sb.toString();
    }
    
    private String generateInstruction(ConstantAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp result = instruction.result;
        Literal lit = instruction.lit;
        if(lit instanceof BooleanLiteral)
        {
            int constant;
            if(((BooleanLiteral)lit).value.booleanValue()){
                constant = 1;
            }
            else
            {
                constant = 0;
            }
            sb.append("    ldc " + constant + "\n");
            sb.append("    istore " + result.getNumber() + "\n");
        }
        else if(lit instanceof CharacterLiteral)
        {
            //gives ASCII value for the character literal
            int constant = (int)((CharacterLiteral)lit).value.charValue();
            sb.append("    ldc " + constant + "\n");
            sb.append("    istore " + result.getNumber() + "\n");
        }
        else if(lit instanceof StringLiteral)
        {
            sb.append("    ldc \""+ lit.value.toString() + "\"\n");
            sb.append("    astore " + result.getNumber() + "\n");
        }
        else if(lit instanceof FloatLiteral)
        {
            sb.append("    ldc "+ lit.value.toString() + "\n");
            sb.append("    fstore " + result.getNumber() + "\n");            
        }
        else
        {
            sb.append("    ldc "+ lit.value.toString() + "\n");
            sb.append("    istore " + result.getNumber() + "\n");
        }
        return sb.toString();
    }
    
    private String generateInstruction(NewArrayAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp result = instruction.t;
        IRType type = instruction.type;
        int size = instruction.size;
        
        sb.append("    ldc "+ size + "\n");
        
        if(type instanceof IRStringType)
        {
            sb.append("    anewarray java/lang/String\n");
        }
        else if(type instanceof IRFloatType)
        {
            sb.append("    newarray float\n");
        }
        else if(type instanceof IRCharacterType)
        {
            sb.append("    newarray char\n");
        }
        else if(type instanceof IRBooleanType)
        {
            sb.append("    newarray boolean\n");
        }
        else
        {
            sb.append("    newarray int\n");
        }
        sb.append("    astore " + result.getNumber() +"\n");
        return sb.toString();
    }
    
    private String generateInstruction(TempAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp lhs = instruction.lhs;
        Temp rhs = instruction.rhs;
        if(lhs.getType() instanceof IRStringType
            || lhs.getType() instanceof IRArrayType)
        {
            sb.append("    aload " + rhs.getNumber() + "\n");
            sb.append("    astore " + lhs.getNumber() + "\n");
        }
        else if(lhs.getType() instanceof IRFloatType)
        {
            sb.append("    fload " + rhs.getNumber() + "\n");
            sb.append("    fstore " + lhs.getNumber() + "\n");
        }
        else
        {
            sb.append("    iload " + rhs.getNumber() + "\n");
            sb.append("    istore " + lhs.getNumber() + "\n");
        }
        return sb.toString();
    }
    
    private String generateInstruction(UnaryOpAssignment instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp lhs = instruction.lhs;
        Temp rhs = instruction.t;
        UnaryOpAssignment.UnaryOp operation = instruction.operation;
        if(operation.equals(UnaryOpAssignment.UnaryOp.CONV))
        {
            //These are the only conversions from table 2 of the IR specification 
            //supported by the JVM instruction set
            if(lhs.getType() instanceof IRIntegerType && rhs.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + rhs.getNumber() + "\n");
                sb.append("    f2i\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
            else if(lhs.getType() instanceof IRFloatType && rhs.getType() instanceof IRIntegerType)
            {
                sb.append("    iload " + rhs.getNumber() + "\n");
                sb.append("    i2f\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else if(lhs.getType() instanceof IRCharacterType && rhs.getType() instanceof IRIntegerType)
            {
                sb.append("    iload " + rhs.getNumber() + "\n");
                sb.append("    i2c\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(UnaryOpAssignment.UnaryOp.NEG))
        {
            if(lhs.getType() instanceof IRIntegerType)
            {
                sb.append("    iload " + rhs.getNumber() + "\n");
                sb.append("    ineg\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
            else if(lhs.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + rhs.getNumber() + "\n");
                sb.append("    fneg\n");
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
        }
        else if(operation.equals(UnaryOpAssignment.UnaryOp.NOT))
        {
            if(lhs.getType() instanceof IRIntegerType)
            {
                sb.append("    iload " + rhs.getNumber() + "\n");
                sb.append("    iconst_m1\n");
                sb.append("    ixor\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
            else if(lhs.getType() instanceof IRBooleanType)
            {
                int firstLabel = getLabel();
                int secondLabel = getLabel();
                sb.append("    iload " + rhs.getNumber() + "\n");
                sb.append("    ifne L_" + firstLabel + "\n");
                sb.append("    iconst_1\n");
                sb.append("    goto L_"+secondLabel+"\n");
                sb.append("L_"+firstLabel+":\n");
                sb.append("    iconst_0\n");
                sb.append("L_"+secondLabel+":\n");
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        return sb.toString();
    }
    
    private String generateInstruction(CallInstruction instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp lhs = instruction.lhs;
        ArrayList<Temp> arguments = instruction.arguments;
        String name = instruction.name;
        
        for(int i = 0; i < arguments.size(); i++)
        {
            if(arguments.get(i).getType() instanceof IRStringType
                || arguments.get(i).getType() instanceof IRArrayType)
            {
                sb.append("    aload " + arguments.get(i).getNumber() + "\n");
            }
            else if(arguments.get(i).getType() instanceof IRFloatType)
            {
                sb.append("    fload " + arguments.get(i).getNumber() + "\n");
            }
            else
            {
                sb.append("    iload " + arguments.get(i).getNumber() + "\n");
            }
        }
        
        sb.append("    invokestatic " + programName + "/" + name + "(");
        
        for(int i = 0; i < arguments.size(); i++)
        {
            sb.append(IRTypeToJasminString(arguments.get(i).getType()));
        }
        
        if(lhs != null)
        {
            sb.append(")");
            sb.append(IRTypeToJasminString(lhs.getType()));
            sb.append("\n");
            
            if(lhs.getType() instanceof IRStringType
                || lhs.getType() instanceof IRArrayType)
            {
                sb.append("    astore " + lhs.getNumber() + "\n");
            }
            else if(lhs.getType() instanceof IRFloatType)
            {
                sb.append("    fstore " + lhs.getNumber() + "\n");
            }
            else
            {
                sb.append("    istore " + lhs.getNumber() + "\n");
            }
        }
        else
        {
            sb.append(")V\n");
        }
        
        return sb.toString();
    }
    
    private String generateInstruction(JumpInstruction instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp condition = instruction.condition;
        int labelNumber = instruction.labelNumber;
        if(condition != null)
        {
            sb.append("    iload " + condition.getNumber() + "\n");
            sb.append("    ifne L"+labelNumber+"\n");
        }
        else
        {
            sb.append("    goto L" + labelNumber + "\n");
        }
        return sb.toString();
    }
    
    private String generateInstruction(LabelInstruction instruction)
    {
        return instruction.toString() + "\n";
    }
    
    private String generateInstruction(PrintInstruction instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp expression = instruction.expression;
        boolean println = instruction.println;
        
        sb.append("    getstatic java/lang/System/out Ljava/io/PrintStream;\n");
        
        if(expression.getType() instanceof IRStringType
                || expression.getType() instanceof IRArrayType)
        {
            sb.append("    aload " + expression.getNumber() + "\n");
        }
        else if(expression.getType() instanceof IRFloatType)
        {
            sb.append("    fload " + expression.getNumber() + "\n");
        }
        else
        {
            sb.append("    iload " + expression.getNumber() + "\n");
        }
        
        sb.append("    invokevirtual java/io/PrintStream/print");
        
        if(println)
        {
           sb.append("ln");
        }
        
        sb.append("(");
        sb.append(IRTypeToJasminString(expression.getType()));
        sb.append(")V\n");
        
        return sb.toString();
    }
    
    private String generateInstruction(ReturnInstruction instruction)
    {
        StringBuilder sb = new StringBuilder();
        Temp expression = instruction.expression;
        if(expression!=null)
        {
            if(expression.getType() instanceof IRStringType
                    || expression.getType() instanceof IRArrayType)
            {
                sb.append("    aload " + expression.getNumber() + "\n");
                sb.append("    areturn\n");
            }
            else if(expression.getType() instanceof IRFloatType)
            {
                sb.append("    fload " + expression.getNumber() + "\n");
                sb.append("    freturn\n");
            }
            else
            {
                sb.append("    iload " + expression.getNumber() + "\n");
                sb.append("    ireturn\n");
            }
        }
        else
        {
            sb.append("    return\n");
        }
        return sb.toString();
    }
}