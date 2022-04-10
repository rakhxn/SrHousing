package Project_1.Views;

import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Quarantine {
    public static void displayMain(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        Button addResident = new Button("Add Resident");
        addResident.setOnAction(e -> {
            QuarantineFunctions.addResident(stage);

        });
        GridPane.setConstraints(addResident,0,0);

        Button generateQuarantineList = new Button("Generate Quarantine List");
        generateQuarantineList.setOnAction(e -> {

        });
        GridPane.setConstraints(generateQuarantineList,0,1);

        Button generateQuarantineHistory = new Button("Generate Quarantine History");
        generateQuarantineHistory.setOnAction(e -> {
        });
        GridPane.setConstraints(generateQuarantineHistory,0,2);

        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e ->{
            View.displayMain(stage);
        });
        GridPane.setConstraints(mainMenu,0,3);

        grid.getChildren().addAll(addResident,generateQuarantineList,generateQuarantineHistory,mainMenu);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();


    }
}
