package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    Connection c;
    public Statement s;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
