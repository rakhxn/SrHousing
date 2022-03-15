package Project_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("SR. Housing");

        button = new Button("Click me");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Sr. Housing", "eirutghiuaeriuh");
            if (result == true){
                Confirmed.display("Confirmed!", "Updated!");
                System.out.println("True!");

            }
            if (result == false){
                System.out.println("Fuck no, gtfo!");
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

}