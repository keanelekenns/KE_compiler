/*
 * Compiler.java
 *
 * Author: Keanelek Enns
 * Last edited: Mar. 29, 2020
 *
 * Description: This class contains the main method for parsing and compiling 
 * programs in the unnamed language (files with extension .ul).
 */

import org.antlr.runtime.*;
import java.io.*;
import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import AST.Types.*;
import IR.*;
import Visitors.*;
import util.*;


public class Compiler {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;
        String filename;
        String programName;
        
		if (args.length < 1 || args.length > 2)
        {
			System.out.println("Usage: Compiler filename.ul [-pp | -ir]");
			return;
		}
        
        filename = args[0];
        input = new ANTLRInputStream(new FileInputStream(filename));
		
        //Trim the filename's path for the IR program name
        if(filename.lastIndexOf("\\") != -1) //Windows File Path
        {
            programName = filename.substring(filename.lastIndexOf("\\")+1,filename.lastIndexOf("."));
        }
        else if(filename.lastIndexOf("/") != -1)
        {
            programName = filename.substring(filename.lastIndexOf("/")+1,filename.lastIndexOf("."));
        }
        else
        {
            programName = filename.substring(0,filename.lastIndexOf("."));
        }
        
		// The name of the grammar here is "unnamedLanguage",
		// so ANTLR generates unnamedLanguageLexer and unnamedLanguageParser
		unnamedLanguageLexer lexer = new unnamedLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		unnamedLanguageParser parser = new unnamedLanguageParser(tokens);

		try 
        {
			Program p = parser.program();
            
            //Perform Type Checking
            TypeVisitor tv = new TypeVisitor();
            tv.visit(p);
            
            //Generate Intermediate Representation (IR)
            IRVisitor iv = new IRVisitor(programName);
            iv.visit(p);
            IRProgram irp = iv.getProgram();
            
            //Generate Java Assembly Interface (Jasmin) code using IR
            //Output jasmin file to same location as input unnamedLanguage file
            JasminGenerator codegen = new JasminGenerator(irp);
            FileWriter jasminFile = new FileWriter(filename.substring(0,filename.lastIndexOf(".")) + ".j");
            jasminFile.write(codegen.generateProgram());
            jasminFile.close();
            
            //OPTIONS
            if(args.length == 2)
            {
                switch(args[1]) 
                { 
                    case "-pp": 
                        //Pretty Print the input program (removes comments) to stdout
                        PrintVisitor pv = new PrintVisitor();
                        pv.visit(p); 
                        break; 
                    case "-ir": 
                        //Print IR to stdout
                        System.out.print(irp.toString()); 
                        break;
                    default: 
                        System.out.println("\""+args[1]+"\" is not a valid option.\n"+
                            "Usage: Compiler filename.ul [-pp | -ir]"); 
                } 
            }
		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
        catch (SemanticException e){
            //Errors detected during type checking stage will be caught here
            System.out.println(e.toString());
        }
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
