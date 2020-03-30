package IR.IRTypes;

public class IRArrayType extends IRType
{
	int size;
    IRType type;
    
	public IRArrayType(int size, IRType type)
    {
        this.size = size;
        this.type = type;
    }
    
    public IRType getType()
    {
        return type;
    }
    
    public int getSize()
    {
        return size;
    }
    
    @Override
    public boolean equals(IRType t)
    {   
        if(!(t instanceof IRArrayType))
        {
            return false;
        }
        else if(!this.type.equals(((IRArrayType)t).getType()) || (this.size != ((IRArrayType)t).getSize()))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public String toString()
    {
        return "A" + type.toString();
    }
        
}
