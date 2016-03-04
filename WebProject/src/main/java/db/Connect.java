package db;

import java.sql.Connection;
import java.sql.*;

/**
 * Created by ANTON on 25.02.2016.
 */
public class Connect {
    public Connect(){
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/Basketball";
        Class.forName("org.postgresql.Driver");
        conn=  DriverManager.getConnection(url, "postgres", "12345");
        return conn;
    }
}
