package Project_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //actual window surrounding the scene
        window = stage;
        window.setTitle("SR. Housing");

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
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        Button login = new Button("Log In");
        GridPane.setConstraints(login,1,2);

        grid.getChildren().addAll(name,nameInput,password,passInput,login);

        Scene scene = new Scene(grid,300,200);
        //casts the window with the scene in it
        window.setScene(scene);
        window.show();

    }
}