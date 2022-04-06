package Project_1;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Confirmed {

    static boolean answer;

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);


        Button okay = new Button("Okay!");


        okay.setOnAction(e ->{
            answer = true;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, okay);
        layout.setAlignment(Pos.CENTER);

        //create two buttons
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}