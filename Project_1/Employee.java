package Project_1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Employee {

    //creates the layout
    public static void display(Stage stage){

        //actual window surrounding the scene
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //First name label
        Label fname = new Label("Employee First Name: ");
        GridPane.setConstraints(fname,0,0);

        //First name input
        TextField firstName = new TextField();
        firstName.setPromptText("First Name"); // grayed out text prompting users to enter their first name
        GridPane.setConstraints(firstName,1,0);

        //Last name label
        Label lname = new Label("Employee Last Name: ");
        GridPane.setConstraints(fname,0,1);

        //Last name input
        TextField lastName = new TextField();
        lastName.setPromptText("Last Name"); // grayed out text prompting users to enter their last name
        GridPane.setConstraints(lastName,1,1);


        //Password label
        Label password = new Label("Password: ");
        GridPane.setConstraints(password,0,2);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,2);

        //Password label
        Label dept = new Label("Department: ");
        GridPane.setConstraints(dept,0,3);

        //Password input
        TextField deptInput = new TextField();
        deptInput.setPromptText("department");
        GridPane.setConstraints(deptInput,1,3);

        //Login button
        Button update = new Button("Update");
        update.setOnAction(e -> {
            try {
                Confirmed.display("SR. Housing", "Updated!");
                    MainWindow.display(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(update,1,4);
        grid.getChildren().addAll(fname,firstName,lname,lastName,password,passInput,dept,deptInput,update);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }
}
