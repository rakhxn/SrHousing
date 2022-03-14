package Project_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Label label1 = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2!");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column
        VBox layout1 = new VBox(20); //20 spaces pixels apart from each other once stacked
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1,200,200);

        Button button2 = new Button("Go to scene 1!");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,200,200);

        window.setTitle("SR. Housing");
        window.setScene(scene1);
        window.show();
    }

    //testing to see if this pops up on windows

}