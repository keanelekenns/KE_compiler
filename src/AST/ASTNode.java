package AST;

public abstract class ASTNode// implements Cloneable
{
    int line;
    int offset;
    
    public void setLine(int line){
        this.line = line;
    }
    public int getLine(){
        return line;
    }
    public void setOffset(int offset){
        this.offset = offset;
    }
    public int getOffset(){
        return offset;
    }
    
    /*@Override
    public Object clone()
    {
        return super.clone();
    }
    */
}
