package org.ssa.ironyard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.ORM;
import org.ssa.ironyard.model.Server;

public interface ServerORM extends ORM<Server>
{
    default String projection()
    {
        return "ServerName";
    }
    
    default String table()
    {
        return "servers";
    }
    
    default Server map(ResultSet results) throws SQLException
    {
        Server s = new Server();
        s.setServer(results.getString("server"));
        return s;
        
    }

    
    default String prepareInsert()
    {
        return "Insert into " + table() + " (ServerName) Values(?)";
    }

    
    default String prepareRead()
    {
        return "Select " + projection() + " FROM " + table() + " WHERE id=?";
    }
    
    
//  default String prepareUpdate()
//  {
//      return "Update " + table() + " Set first = ?, last = ? Where id=?";
//  }
    
//    default String prepareDelete()
//    {
//        return "Delete From " + table() + " WHERE id=?";
//    }

        


}
