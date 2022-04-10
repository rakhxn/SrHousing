package Project_1;

import Project_1.Views.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class View {
    public static void displayLogin(Stage stage){
        //actual window surrounding the scene
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label name = new Label("Username: ");
        GridPane.setConstraints(name,0,0);

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username"); // grayed out text prompting users to enter their username
        GridPane.setConstraints(nameInput,1,0);

        //Password label
        Label password = new Label("Password: ");
        GridPane.setConstraints(password,0,1);

        //Password input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Login button
        Button login = new Button("Log In");
        login.setOnAction(e -> {
                try {
                    Controller.userExists(stage,Objects.requireNonNull(Connector.getConnection()),nameInput.getText(),passInput.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        });

        //sets the layout together
        GridPane.setConstraints(login,1,2);
        grid.getChildren().addAll(name,nameInput,password,passInput,login);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();


    }

    public static void displayMain(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(10);

        //Login button
        Button logout = new Button("Log Out");
        logout.setOnAction(e -> {
            try {
                View.displayLogin(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(logout,1,4);

        Button manageEmployee = new Button("Manage Employee");
        manageEmployee.setOnAction(e -> {
            try {
                Employee.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(manageEmployee,0,0);

        Button manageResidents = new Button("Manage Resident");
        manageResidents.setOnAction(e -> {
            try {
                Residents.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(manageResidents,1,0);

        Button quarantineLists = new Button("Quarantine List");
        quarantineLists.setOnAction(e -> {
            try {
                Quarantine.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(quarantineLists,0,1);

        Button requests = new Button("Requests");
        requests.setOnAction(e -> {
            try {
                Requests.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(requests,1,1);

        Button missedMeal = new Button("Missed Meal");
        missedMeal.setOnAction(e -> {
            try {
                MissedMeal.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(missedMeal,0,2);

        Button hospitalList = new Button("Hospital List");
        hospitalList.setOnAction(e -> {
            try {
                HospitalList.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(hospitalList,1,2);


        grid.getChildren().addAll(manageEmployee,manageResidents,quarantineLists,requests,missedMeal,hospitalList,logout);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();

    }



}
