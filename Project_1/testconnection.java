package Project_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testconnection {
    public static void main(String[] args) throws Exception {
        getConnection();

    }

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/cus1156","root","password");
            System.out.println("Successfully connected to database");
            return conn;
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println(e);
            return null;
        }
    }
}
