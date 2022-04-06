package Project_1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);


        Button errorButton = new Button("Okay!");

        errorButton.setOnAction(e ->{
            answer = true;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, errorButton);
        layout.setAlignment(Pos.CENTER);

        //create two buttons
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;


    }
}