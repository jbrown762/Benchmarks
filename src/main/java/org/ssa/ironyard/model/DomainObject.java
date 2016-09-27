package org.ssa.ironyard.model;


public interface DomainObject
{
    
    public default Integer getId()
    {
        return null;
        
    }

    
    public default boolean deeplyEquals(Object obj)
    {
        return false;
   
        
    }
    
    
    
    public default boolean isLoaded()
    {
        return false;
       
     
    }
}
