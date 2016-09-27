package org.ssa.ironyard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssa.ironyard.dao.ServerDAO;
import org.ssa.ironyard.model.Server;

@Service
public class ServerService
{
    final ServerDAO serverDAO;

    @Autowired
    public ServerService(ServerDAO serverDAO)
    {
        this.serverDAO = serverDAO;
    }

    public Server insertServer(Server server)
    {
        return serverDAO.insert(server);
    }

    public Server readServer(int id)
    {
        return serverDAO.read(id);
    }

    // TODO

    // public Server updateServer(Server server)
    // {
    // return serverDAO.update(server);
    // }
    //
    // public boolean deleteServer(int id)
    // {
    // return serverDAO.delete(id);
    // }
}