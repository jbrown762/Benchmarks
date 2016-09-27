package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.ssa.ironyard.model.Language;

public class LanguageDAOImpl extends AbstractDAO<Language> implements LanguageDAO
{
    @Autowired
    public LanguageDAOImpl(DataSource datasource)
    {
        super(datasource, new LanguageORM()
        {
        });

    }

    @Override
    public Language insert(Language language)
    {
        Connection connection = null;
        Language l = null;
        PreparedStatement prepareStatement;
        
        try
        {
            connection = datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, language.getLanguage());

            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

            if (generatedKeys.next())
                l = new Language(generatedKeys.getInt(1), language.getLanguage());

            cleanup(connection);
            return l;

        } catch (SQLException e)
        {
            return l;
        }

    }

}
