package util;

public class SemanticException extends Exception
{
    String message;
    int line;
    int offset;
    
    public SemanticException(String message, int line, int offset){
        this.message = message;
        this.line = line;
        this.offset = offset;
    }     

    public String toString(){
        return "Error at line " + line + ", offset " + offset + ":\n" + message;
    }
}