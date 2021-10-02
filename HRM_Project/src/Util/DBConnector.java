package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hr";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {
        Connection con;
        Statement s;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            return con;
        } catch (Exception e) {
            return null;
         }
      

    }
}
