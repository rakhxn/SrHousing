package Project_1;

import Views.Employee;
import Views.ResidentsFunctions;
import Views.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {


    // ================================================================================================================================== //
    //                                        ADMIN MANAGE EMPLOYEE FUNCTIONS                                                             //
    // ================================================================================================================================== //

    //checks to see if user exists
    public static boolean userExists(Stage stage, Connection conn, String name, String password) throws Exception {

        boolean exists = false;
        String userResult = null;
        String passResult = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM employees WHERE firstname = '" + name +"';"
        );

        while (rs.next()) {
            userResult = rs.getString("firstname");
            passResult = rs.getString("password");
        }

        if(userResult == null || passResult == null){
            Confirmed.display("Error!", "Try again!");
        }
        else if(userResult.equals(name.toLowerCase()) && passResult.equals(password)){
            exists = true;
            View.displayMain(stage);
        }
        else if(userResult.equals(name.toLowerCase()) && !passResult.equals(password)){
            Confirmed.display("Error!", "Incorrect Password, try again!");
        }
        return exists;
    }

    // adds employee to the database
    public static void addEmployee(Stage stage, Connection conn, String firstName, String password, String dept) throws Exception {
        try{
            PreparedStatement posted = conn.prepareStatement("INSERT INTO employees (firstname,password,department) VALUES ('" + firstName + "','" + password + "','" + dept + "')");
            posted.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Completed!");
        }
    }

    // sets user to admin or employee
    public static void setAdmin(Stage stage, Connection conn,String name) throws Exception {
        try {
            PreparedStatement posted = conn.prepareStatement("UPDATE employees SET admin = '" + "yes" +"' WHERE firstname = '" + name +"';");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed!");
        }
    }
    public static void setEmployee(Stage stage, Connection conn,String name) throws Exception {
        try {
            PreparedStatement posted = conn.prepareStatement("UPDATE employees SET admin = '" + "no" +"' WHERE firstname = '" + name +"';");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed!");
        }
    }

    // removes employee from the database
    public static void removeEmployee(Stage stage, Connection conn, String name) throws Exception {
        String userResult = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM employees WHERE firstname = '" + name +"';"
        );
        while (rs.next()) {
            userResult = rs.getString("firstname");
        }
        if(userResult == null || !userResult.equals(name)){
            Confirmed.display("Error!", "Try again!");
        }
        else if(userResult.equals(name.toLowerCase())){
            PreparedStatement posted = conn.prepareStatement("DELETE FROM employees WHERE firstname = '" + name +"';");
            posted.executeUpdate();
            Confirmed.display("SR. Housing", "Removed!");        }

    }

    // updates password for
    public static void changePassword(Stage stage, Connection conn, String name, String opass, String npass) throws Exception {
        if(userExists(stage,conn,name,opass)){
            String userResult = null;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM employees WHERE firstname = '" + name +"';");
            while (rs.next()) {
                userResult = rs.getString("firstname");
            }
            if(userResult == null || !userResult.equals(name)){
                Confirmed.display("Error!", "Try again!");
            }
            else if(userResult.equals(name.toLowerCase())){
                PreparedStatement posted = conn.prepareStatement("UPDATE employees SET password = '" + npass +"' WHERE firstname = '" + name +"';");
                posted.executeUpdate();
                Confirmed.display("SR. Housing", "Updated!");
                Employee.displayMain(stage);
            }
        }
    }

    // ================================================================================================================================== //
    //                                              MANAGE RESIDENTS FUNCTIONS                                                             //
    // ================================================================================================================================== //



}
