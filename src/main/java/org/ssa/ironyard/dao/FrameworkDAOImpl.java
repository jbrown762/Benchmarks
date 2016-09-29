package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.ssa.ironyard.model.Framework;

public class FrameworkDAOImpl extends AbstractDAO<Framework> implements FrameworkDAO
{

    @Autowired
    public FrameworkDAOImpl(DataSource datasource)
    {
        super(datasource, new FrameworkORM()
        {
        });

    }

    @Override
    public Framework insert(Framework framework)
    {
        Connection connection = null;
        Framework f = null;
        PreparedStatement prepareStatement;

        try
        {
            connection = datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, framework.getFramework());
            prepareStatement.setString(2, framework.getLanguage().getLanguage());
            prepareStatement.setString(3, framework.getServer().getServer());
            prepareStatement.setInt(4, framework.getThreads8());
            prepareStatement.setInt(5, framework.getThreads16());
            prepareStatement.setInt(6, framework.getThreads32());
            prepareStatement.setInt(7, framework.getThreads64());
            prepareStatement.setInt(8, framework.getThreads128());
            prepareStatement.setInt(9, framework.getThreads256());
            prepareStatement.setInt(10, framework.getErrors());

            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

            if (generatedKeys.next())
            {
                f = new Framework();
                f.setId(generatedKeys.getInt(1));
                f.setFramework(framework.getFramework());
                f.setLanguage(framework.getLanguage());
                f.setServer(framework.getServer());
                f.setThreads8(framework.getThreads8());
                f.setThreads16(framework.getThreads16());
                f.setThreads32(framework.getThreads32());
                f.setThreads64(framework.getThreads64());
                f.setThreads128(framework.getThreads128());
                f.setThreads256(framework.getThreads256());
                f.setErrors(framework.getErrors());
            }
            return f;

        } catch (SQLException e)
        {
            return f;
        } finally
        {
            cleanup(connection);
        }

    }

}
