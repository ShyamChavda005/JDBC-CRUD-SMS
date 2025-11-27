
package org.example;

import java.sql.*;

class DBConnect {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}