package com.example.project_db1;

import java.sql.*;
import javax.sql.rowset.*;

public class DBUtil {
    private static Connection db = null;

    public static void connect(){
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://ella.db.elephantsql.com:5432/afyzkewq";
        String username = "afyzkewq";
        String password = "Vl2rfCrrPdRiiXl8lksjOleWcn9bhKK8";

        try {
            db = DriverManager.getConnection(url, username, password);
            System.out.println("Polaczono");
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void disconnect() throws SQLException{
        try{
            if(db != null && !db.isClosed()){
                db.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void executeQuery(String statement) throws SQLException{
        Statement statement1 = null;
        try{
            connect();
            statement1 = db.createStatement();
            statement1.executeUpdate(statement);
        }
        catch(SQLException e){
            System.out.println("Nie udalo sie dodac rekordu");
            throw e;
        }
        finally{
            if(statement1!=null){
                statement1.close();
            }
            disconnect();
        }
    }

    public static ResultSet getRecords(String query) throws SQLException{
        Statement statement = null;
        ResultSet result = null;
        CachedRowSet crs= null;

        try{
            connect();
            statement = db.createStatement();
            result = statement.executeQuery(query);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(result);
            return crs;
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Nie udalo sie dostac rekordow");
        }
        finally{
            if(result!=null){
                result.close();
            }
            if(statement!=null){
                statement.close();
            }
            disconnect();
        }
        return crs;
    }
}

