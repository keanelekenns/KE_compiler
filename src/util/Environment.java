package util;

import java.util.ArrayList;

public class Environment<K,V>
{
    private ArrayList<Pair<K,V>> list;
    
	public Environment()
    {
        list = new ArrayList<Pair<K,V>>();
    }
    
    public void push(K key, V val)
    {
        try
        {
            testPair(key, val);
        }
        catch(DuplicateKeyException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        catch(NullElementException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        
        list.add(new Pair<K,V>(key,val));
    }
    
    private void testPair(K key, V val) throws DuplicateKeyException, NullElementException
    {
        if(key==null || val==null)
        {
            throw new NullElementException();
        }
        else if (containsInScope(key))
        {
            throw new DuplicateKeyException();
        }
    }
    
    public boolean containsInScope(K key)
    {
        if(getInScope(key) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    //Return the value of the given key in the current scope,
    //if the key does not exist in the current scope, return null.
    public V getInScope(K key)
    {
        if(key == null)
        {
            return null;
        }

        int size = list.size();
        
        for(int i = size-1; i>=0 ; i--)
        {
            if(list.get(i).getKey() == null)
            {
               return null; //reached end of scope
            }
            else if(key.equals(list.get(i).getKey()))
            {
                return list.get(i).getValue();
            }
        }
        return null;
    }
    
    public void beginScope(){
        list.add(new Pair<K,V>(null,null));
    }
    
    //Removes every element in the current scope
    public void endScope()
    {
        int size = list.size();
        
        //we use globalScope to determine if a call to beginScope has been made
        boolean globalScope = true;
        
        for(int i = size-1; i>=0 ; i--)
        {
            if(list.get(i).getKey() == null)
            {
                globalScope = false;
                break;               
            }
        }
        
        if(globalScope == true){
            return;
        }
        
        while(list.get(size-1).getKey() != null)
        {
            list.remove(size-1);
            size--;
        }
        list.remove(size-1);
        return;
    }
}
