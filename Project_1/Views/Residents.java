package Project_1.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Residents {
    public static void displayMain(Stage stage) {

        stage.setTitle("Sr. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(10);

        Button addResident = new Button("Add Resident");
        addResident.setOnAction(e -> {
            ResidentsFunctions.addResident(stage);
        });
        GridPane.setConstraints(addResident,0,0);

        Button removeResident = new Button("Remove Resident");
        removeResident.setOnAction(e -> {
            ResidentsFunctions.removeResident(stage);
        });
        GridPane.setConstraints(removeResident,0,1);

        Button updateResident = new Button("Update Resident");
        updateResident.setOnAction(e -> {
            ResidentsFunctions.updateResident(stage);
        });
        GridPane.setConstraints(updateResident,0,2);

        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e -> {
            try {
                View.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(mainMenu,0,3);

        grid.getChildren().addAll(addResident,removeResident,updateResident,mainMenu);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();

    }
}