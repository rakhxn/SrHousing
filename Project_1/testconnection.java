package Project_1;

import java.sql.*;

public class testconnection {

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

    public static Boolean userExists(Connection conn, String name, String password) throws Exception {
        boolean exists = false;
        String userResult = null;
        String passResult = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM employees WHERE username = '" + name +"';"
        );






        while (rs.next()) {
            userResult = rs.getString("username");
            passResult = rs.getString("password");
        }



        if(userResult == null || passResult == null){
            ErrorBox.display("Error!", "Try again!");
        }
        else if(userResult.equals(name.toLowerCase()) && passResult.equals(password)){
            System.out.println("Works!");
            exists = true;
        }
        else if(userResult.equals(name.toLowerCase()) && !passResult.equals(password)){
            System.out.println("Incorrect password!");
            ErrorBox.display("Error!", "Incorrect Password, try again!");
        }

        return exists;
    }
}
