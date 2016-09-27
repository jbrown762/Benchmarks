package org.ssa.ironyard.model;

public class Language implements DomainObject
{
    Integer id;
    String language;
    
    public Language()
    {
    }
    
    public Language(String language)
    {
        this.language = language;
    }
    
    public Language(Integer id, String language)
    {
        this.id = id;
        this.language = language;
    }
    
    public void setLanguage(String language)
    {
        this.language = language;
    }
    
    public String getLanguage()
    {
        return language;
    }
}
