package Project_1;

import java.sql.*;
public class Connector {

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/srHousing","root","password");
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("Error: " + e);
            return null;
        }
    }

}
