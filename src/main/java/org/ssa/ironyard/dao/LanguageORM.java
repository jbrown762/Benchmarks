package org.ssa.ironyard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Language;
import org.ssa.ironyard.model.ORM;

public interface LanguageORM extends ORM<Language>
{
    default String projection()
    {
        return "name";
    }

    default String table()
    {
        return "Languages";
    }

    default Language map(ResultSet results) throws SQLException
    {
        Language f = new Language();
        f.setLanguage(results.getString("language"));
        return f;

    }

    default String prepareInsert()
    {
        return "Insert into " + table() + " (language) Values(?)";
    }

    default String prepareRead()
    {
        return "Select " + projection() + " FROM " + table() + " WHERE id=?";
    }

    // default String prepareUpdate()
    // {
    // return "Update " + table() + " Set first = ?, last = ? Where id=?";
    // }

    // default String prepareDelete()
    // {
    // return "Delete From " + table() + " WHERE id=?";
    // }

}
