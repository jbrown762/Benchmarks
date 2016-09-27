package org.ssa.ironyard.dao;

import org.ssa.ironyard.model.Server;

public interface ServerDAO
{
    Server insert(Server f);
    Server read(int id);
}
