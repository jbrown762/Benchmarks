package org.ssa.ironyard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.ORM;



public interface FrameworkORM extends ORM<Framework>
{
    default String projection()
    {
        return "framework";
    }
    
    default String table()
    {
        return "WebFrameworks";
    }
    
    default Framework map(ResultSet results) throws SQLException
    {
        Framework f = new Framework();
        f.setFramework(results.getString("framework"));
        return f;
        
    }

    
    default String prepareInsert()
    {
        return "Insert into " + table() + " (framework, language, server, threads8, threads16, threads32, threads64, threads128, threads256, errors) Values(?,?,?,?,?,?,?,?,?,?)";
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
