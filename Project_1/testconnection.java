package Project_1;

import java.sql.*;
import java.util.ArrayList;

public class testconnection {
    public static void main(String[] args) throws Exception {
        String name = "dafad";
        userExists(getConnection(),name);

    }

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cus1156","root","password");
            return conn;
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public static Boolean userExists(Connection conn, String name) throws Exception {
        Boolean exists = false;
        String queryResult = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM users WHERE user = '" + name +"';"
        );

        while (rs.next()) {
            queryResult = rs.getString("user");
        }
        if(queryResult != null){
            System.out.println("User: " + queryResult + " exists!");
            exists = true;
        }
        else {
            System.out.println("User not found!");
        }

        return exists;
    }
}