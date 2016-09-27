package org.ssa.ironyard.model;

public class Benchmark implements DomainObject
{

    Framework webFramework;
    Language language;
    Server server;
       
    int threads8;
    int threads16;
    int threads32;
    int threads64;
    int threads128;
    int threads256;
    int errors;
    
    
    public void setFramework(Framework webFramework)
    {
        this.webFramework = webFramework;
    }


    public void setLanguage(Language language)
    {
        this.language = language;
    }


    public void setServer(Server server)
    {
        this.server = server;
    }

}
