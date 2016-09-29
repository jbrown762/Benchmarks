package org.ssa.ironyard.model;

public class Framework implements DomainObject
{
    Integer id;

    String framework;
    Language language;
    Server server;

    int threads8, threads16, threads32, threads64, threads128, threads256, errors;

    public Framework()
    {
    }

    public Framework(Integer id)
    {
        setId(id);
    }

    public Framework(String framework, Language language, Server server, int threads8, int threads16, int threads32,
            int threads64, int threads128, int threads256, int errors)
    {
        this.framework = framework;
        this.language = language;
        this.server = server;
        this.threads8 = threads8;
        this.threads16 = threads16;
        this.threads32 = threads32;
        this.threads64 = threads64;
        this.threads128 = threads128;
        this.threads256 = threads256;
        this.errors = errors;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFramework()
    {
        return framework;
    }

    public Language getLanguage()
    {
        return language;
    }

    public Server getServer()
    {
        return server;
    }

    public int getThreads8()
    {
        return threads8;
    }

    public int getThreads16()
    {
        return threads16;
    }

    public int getThreads32()
    {
        return threads32;
    }

    public int getThreads64()
    {
        return threads64;
    }

    public int getThreads128()
    {
        return threads128;
    }

    public int getThreads256()
    {
        return threads256;
    }

    public int getErrors()
    {
        return errors;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setFramework(String framework)
    {
        this.framework = framework;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public void setServer(Server server)
    {
        this.server = server;
    }

    public void setThreads8(int threads8)
    {
        this.threads8 = threads8;
    }

    public void setThreads16(int threads16)
    {
        this.threads16 = threads16;
    }

    public void setThreads32(int threads32)
    {
        this.threads32 = threads32;
    }

    public void setThreads64(int threads64)
    {
        this.threads64 = threads64;
    }

    public void setThreads128(int threads128)
    {
        this.threads128 = threads128;
    }

    public void setThreads256(int threads256)
    {
        this.threads256 = threads256;
    }

    public void setErrors(int errors)
    {
        this.errors = errors;
    }

    @Override
    public Framework clone()
    {
        try
        {
            return (Framework) super.clone();
        } catch (Exception e)
        {

        }
        return null;
    }

    @Override
    public boolean deeplyEquals(Object obj)
    {
        
        return false;
    }

}
