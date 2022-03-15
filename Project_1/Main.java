package Project_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("SR. Housing");

        HBox topMenu = new HBox();
        Button file = new Button("File");
        Button edit = new Button("Edit");
        Button view = new Button("View");
        topMenu.getChildren().addAll(file,edit,view);

        VBox leftMenu = new VBox();
        Button file1 = new Button("File1");
        Button edit1 = new Button("Edit1");
        Button view1 = new Button("View1");
        leftMenu.getChildren().addAll(file1,edit1,view1);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane,300,250);
        window.setScene(scene);
        window.show();
    }
}