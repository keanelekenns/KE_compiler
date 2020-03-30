package util;

public class Pair<K,V>
{
    K key;
    V val;
    
    public Pair(K key, V val)
    {
        this.key = key;
        this.val = val;
    }
    
    public K getKey()
    {
        return key;
    }
    
    public V getValue()
    {
        return val;
    }
}
