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
        Button login = new Button("Log Out");
        login.setOnAction(e -> {
            try {
                Login.display(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(login,1,2);
        grid.getChildren().addAll(login);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }
}
