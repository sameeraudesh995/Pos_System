package dao;

import db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CrudUtil {
    //get prepared statement
    public PreparedStatement getPreparedStatement(String query, Objects...args) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i=0; i< args.length; i++ ){
            statement.setObject(i+1,args[i]);
        }
        return statement;

    }
    public boolean executeUpdate(String query, Objects...args ) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(query,args).executeUpdate() > 0;
    }
    public ResultSet executeQuery(String query, Objects...args) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(query,args).executeQuery();
    }
}
