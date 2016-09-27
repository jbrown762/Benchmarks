package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.ssa.ironyard.model.DomainObject;
import org.ssa.ironyard.model.ORM;


public abstract class AbstractDAO <T extends DomainObject>
{
    protected final DataSource datasource;
    protected final ORM<T> orm;
    
    
    protected AbstractDAO(DataSource datasource, ORM<T> orm)
    {
        this.datasource = datasource;
        this.orm = orm;
    }
    
    public abstract T insert(T domain);

    

    public T read(int id)
    {
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
        try
        {
            connection = this.datasource.getConnection();
            read = connection.prepareStatement(this.orm.prepareRead());
            read.setInt(1, id);
            query = read.executeQuery();
            
            if (query.next())
                return this.orm.map(query);

        }
        catch (Exception ex)
        {

        }
        finally
        {
            cleanup(query, read, connection);
        }
        return null;
    }
    
    static protected void cleanup(ResultSet results, Statement statement, Connection connection)
    {
       try
       {
           if(results != null)
               results.close();
           
       }
       catch(SQLException e)
       {
           throw new RuntimeException();
       }
       cleanup(statement, connection);

    }

    static protected void cleanup(Statement statement, Connection connection)
    {
        try
        {
            if(statement != null)
                statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            throw new RuntimeException();
        }
    }
    
    static protected void cleanup(Connection connection)
    {
        try
        {
            if(connection != null)
                connection.close();
        }
        catch(SQLException e)
        {
            throw new RuntimeException();
        }
    }
}
