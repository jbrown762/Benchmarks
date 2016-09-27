package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.ssa.ironyard.model.Server;

public class ServerDAOImpl extends AbstractDAO<Server> implements ServerDAO
{
    @Autowired
    public ServerDAOImpl(DataSource datasource)
    {
        super(datasource, new ServerORM()
        {
        });

    }

    @Override
    public Server insert(Server server)
    {
        Connection connection = null;
        Server s = null;
        PreparedStatement prepareStatement;

        try
        {
            connection = datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, server.getServer());

            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

            if (generatedKeys.next())
                s = new Server(generatedKeys.getInt(1), server.getServer());

            return s;

        } catch (SQLException e)
        {
            return s;
        } finally
        {
            cleanup(connection);
        }

    }

}
