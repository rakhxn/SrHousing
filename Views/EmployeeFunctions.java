package Views;

import Project_1.Confirmed;
import Project_1.Connector;
import Project_1.Controller;
import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class EmployeeFunctions {

    public static void addEmployee(Stage stage){

        //actual window surrounding the scene
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //First name label
        Label username = new Label("Username: ");
        GridPane.setConstraints(username,0,0);

        //First name input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("UserName"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(usernameInput,1,0);

        //Password label
        Label password = new Label("Password: ");
        GridPane.setConstraints(password,0,1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Password label
        Label dept = new Label("Department: ");
        GridPane.setConstraints(dept,0,2);

        //Password input
        TextField deptInput = new TextField();
        deptInput.setPromptText("department");
        GridPane.setConstraints(deptInput,1,2);

        //Login button
        Button addEmployee = new Button("Add Employee");
        addEmployee.setOnAction(e -> {
            try {
                Controller.addEmployee(stage, Objects.requireNonNull(Connector.getConnection()),usernameInput.getText(),passInput.getText(),deptInput.getText());
                Controller.setEmployee(stage,Connector.getConnection(),usernameInput.getText());
                Confirmed.display("SR. Housing", "Updated!");
                Employee.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button addAdmin = new Button("Add Admin");
        addAdmin.setOnAction(e -> {
            try {
                Controller.addEmployee(stage, Objects.requireNonNull(Connector.getConnection()),usernameInput.getText(),passInput.getText(),deptInput.getText());
                Controller.setAdmin(stage,Connector.getConnection(),usernameInput.getText());
                Confirmed.display("SR. Housing", "Updated!");
                Employee.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button returnhome = new Button("Return");
        returnhome.setOnAction(e -> {
            Employee.displayMain(stage);
        });

        //sets the layout together
        GridPane.setConstraints(addEmployee,0,4);
        GridPane.setConstraints(addAdmin,1,4);
        GridPane.setConstraints(returnhome,0,5);



        grid.getChildren().addAll(username,usernameInput,password,passInput,dept,deptInput,addEmployee,addAdmin,returnhome);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();

    }

    public static void removeEmployee(Stage stage){

        //actual window surrounding the scene
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //First name label
        Label username = new Label("Username: ");
        GridPane.setConstraints(username,0,0);

        //First name input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("UserName"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(usernameInput,1,0);


        Button returnhome = new Button("Return");
        returnhome.setOnAction(e -> {
            try {
                Employee.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(returnhome,0,4);
        //Login button
        Button removeEmployee = new Button("Remove Employee");
        removeEmployee.setOnAction(e -> {
            try {
                Controller.removeEmployee(stage,Connector.getConnection(),usernameInput.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(removeEmployee,1,4);

        grid.getChildren().addAll(username,usernameInput,returnhome,removeEmployee);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();

    }

    public static void changePassword(Stage stage){

        //actual window surrounding the scene
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //First name label
        Label username = new Label("Username: ");
        GridPane.setConstraints(username,0,0);

        //First name input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("UserName"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(usernameInput,1,0);

        Label oldPassword = new Label("Old Password: ");
        GridPane.setConstraints(oldPassword,0,1);

        //First name input
        TextField oldPasswordInput = new TextField();
        oldPasswordInput.setPromptText("Password"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(oldPasswordInput,1,1);


        Label newPassword = new Label("New Password: ");
        GridPane.setConstraints(newPassword,0,2);

        //First name input
        TextField newPasswordInput = new TextField();
        newPasswordInput.setPromptText("Password"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(newPasswordInput,1,2);


        Button returnhome = new Button("Return");
        returnhome.setOnAction(e -> {
            try {
                Employee.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(returnhome,0,4);
        //Login button
        Button updatePassword = new Button("Update Password");
        updatePassword.setOnAction(e -> {
            try {
                Controller.changePassword(stage, Objects.requireNonNull(Connector.getConnection()),usernameInput.getText(),oldPasswordInput.getText(),newPasswordInput.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(updatePassword,1,4);

        grid.getChildren().addAll(username,usernameInput,oldPassword,oldPasswordInput,newPassword,newPasswordInput,returnhome,updatePassword);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();

    }
}
