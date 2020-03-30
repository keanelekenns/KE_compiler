package IR;

import IR.IRTypes.*;

public class Temp
{
    int number;
    IRType type;
    Category category;
    
    public enum Category { PARAM, LOCAL, TEMP }
    
    public Temp(int number, IRType type, Category category)
    {
        this.number = number;
        this.type = type;
        this.category = category;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public IRType getType()
    {
        return type;
    }
    
    public Category getCategory()
    {
        return category;
    }
    
    public String toString()
    {
        return "T" + number;
    }
}