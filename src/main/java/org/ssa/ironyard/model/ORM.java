package org.ssa.ironyard.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ORM<T extends DomainObject>
{
    String projection();
    String table();
    T map(ResultSet results) throws SQLException;
    String prepareInsert();
    String prepareRead();
//    String prepareDelete();
//    String prepareDeleteAll();

   

//    String eagerRead();
//    T deepMap(ResultSet query) throws SQLException;
//    String eagerReadUser();
//    String eagerReadType();
//    String eagerPrepareReadLessThan();


    

 


}