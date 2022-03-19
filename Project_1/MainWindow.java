package Project_1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow {

    static boolean answer;

    public static void display(Stage stage){
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        //Login button
        Button logout = new Button("Log Out");
        logout.setOnAction(e -> {
            try {
                Login.display(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(logout,1,2);

        Button addEmployee = new Button("Add Employee");
        addEmployee.setOnAction(e -> {
            try {
                Employee.display(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //sets the layout together
        GridPane.setConstraints(addEmployee,0,0);

        grid.getChildren().addAll(addEmployee,logout);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }
}
