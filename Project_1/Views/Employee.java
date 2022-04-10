package Project_1.Views;

import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Employee {
    public static void displayMain(Stage stage){

        // DEFINES THE SIZE OF BOX

        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(10);


        // ADD EMPLOYEE BUTTON
        Button addEmployee = new Button("Add Employee");
        addEmployee.setOnAction(e -> {
            try {
                EmployeeFunctions.addEmployee(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(addEmployee,0,0);


        // REMOVE EMPLOYEE BUTTON
        Button removeEmployee = new Button("Remove Employee");
        removeEmployee.setOnAction(e -> {
            try {
                EmployeeFunctions.removeEmployee(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(removeEmployee,0,1);


        // EDIT PASSWORD BUTTON
        Button editPassword = new Button("Edit Password");
        editPassword.setOnAction(e -> {
            try {
                EmployeeFunctions.changePassword(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(editPassword,0,2);


        // MAIN MENU BUTTON
        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e -> {
            try {
                View.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(mainMenu,0,4);

        // ADDS ALL BUTTONS TO GRID
        grid.getChildren().addAll(addEmployee,removeEmployee,editPassword,mainMenu);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }
}
