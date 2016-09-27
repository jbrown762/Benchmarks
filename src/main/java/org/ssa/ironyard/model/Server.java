package org.ssa.ironyard.model;

public class Server implements DomainObject
{

    Integer id;
    String server;

    public Server()
    {
    }

    public Server(String server)
    {
        this.server = server;
    }

    public Server(int id, String server)
    {
        this.id = id;
        this.server = server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    public String getServer()
    {
        return server;
    }
}
