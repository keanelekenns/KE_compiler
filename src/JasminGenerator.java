import java.io.*;
import IR.*;
import IR.IRTypes.*;
import IR.Instructions.*;
import util.*;

public class JasminGenerator 
{
    IRProgram program;
    JasminInstructionGenerator instGen;
    
	public JasminGenerator(IRProgram program)
    {
        this.program = program;
        instGen = new JasminInstructionGenerator(program.getName());
    }
    
    public String generateProgram()
    {
        // The size of the IR file will likely be smaller than
        // the size of the generated Jasmin file.
        StringBuilder sb = new StringBuilder(program.toString().length());
        sb.append(".class public "+program.getName()+"\n.super java/lang/Object\n\n");
        int functionCount = program.getFunctionCount();
        for(int i=0; i<functionCount; i++)
        {
            sb.append(generateFunction(program.getFunctionAt(i)));
            sb.append("\n");
        }
        sb.append(";--------------------------------------------;\n")
        .append(";                                            ;\n")
        .append("; Boilerplate                                ;\n")
        .append(";                                            ;\n")
        .append(";--------------------------------------------;\n")
        .append(".method public static main([Ljava/lang/String;)V\n")
        .append("    ; set limits used by this method\n")
        .append("    .limit locals 1\n")
        .append("    .limit stack 4\n")
        .append("    invokestatic "+program.getName()+"/__main()V\n")
        .append("    return\n")
        .append(".end method\n")
        .append("\n")
        .append("; standard initializer\n")
        .append(".method public <init>()V\n")
        .append("    aload_0\n")
        .append("    invokenonvirtual java/lang/Object/<init>()V\n")
        .append("    return\n")
        .append(".end method");
        return sb.toString();
    }
    
    private String generateFunction(IRFunction function)
    {
        StringBuilder sb = new StringBuilder();
        String funcName = function.getName();
        if(funcName.equals("main"))
        {
            funcName = "__main";
        }
        
        sb.append(".method public static "+funcName+"(");
        int parameterCount = function.getParameterCount();
        for(int i = 0; i < parameterCount; i++)
        {
            sb.append(instGen.IRTypeToJasminString(function.getTempAt(i).getType()));
        }
        sb.append(")");
        sb.append(instGen.IRTypeToJasminString(function.getReturnType()));
        sb.append("\n");
        
        sb.append("    .limit locals " + function.getTempCount()+"\n");
        sb.append("    .limit stack 50\n");
        
        int instructionCount = function.getInstructionCount();
        for(int i = 0; i < instructionCount; i++)
        {
            Instruction inst = function.getInstructionAt(i);
            sb.append(";       " + inst.toString() + "\n");
            sb.append(instGen.generateInstruction(inst));
        }
        if(instructionCount == 0 || !(function.getInstructionAt(instructionCount-1) instanceof ReturnInstruction))
        {
            sb.append("    return\n");
        }
        sb.append(".end method\n\n");
        return sb.toString();
    }
}
