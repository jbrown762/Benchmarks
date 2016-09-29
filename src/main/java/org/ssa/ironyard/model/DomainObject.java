package org.ssa.ironyard.model;

public interface DomainObject extends Cloneable
{

    public default Integer getId()
    {
        return null;
    }

    boolean deeplyEquals(Object obj);


    public default boolean isLoaded()
    {
        return false;
    }

    @Override
    String toString();

    @Override
    int hashCode();
    
}
