package Project_1.Views;

import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MissedMeal {
    public static void displayMain(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);

        //ADD RESIDENT TO MISSED MEAL LIST
        Button addMissedMeal = new Button("Add Missed Meal");
        addMissedMeal.setOnAction(e -> {
            MissedMealFunctions.addMissedMeal(stage);
        });
        GridPane.setConstraints(addMissedMeal,0,0);

        //MARK RESIDENT CONTACTED
        Button markContacted = new Button("Mark Contacted");
        markContacted.setOnAction(e -> {
            MissedMealFunctions.markContacted(stage);
        });
        GridPane.setConstraints(markContacted,0,1);

        //GENERATE UNCONTACTED LOGS
        Button genUncontacted = new Button("Generate Uncontacted Logs");
        genUncontacted.setOnAction(e -> {
            //include generate nurse logs
        });
        GridPane.setConstraints(genUncontacted,0,2);

        //GENERATE ALL LOGS
        Button genAllLogs = new Button("Generate All Logs");
        genAllLogs.setOnAction(e -> {
            //include generate maintenance function
        });
        GridPane.setConstraints(genAllLogs,0,3);


        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e ->{
            try {
                View.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(mainMenu,0,4);

        grid.getChildren().addAll(addMissedMeal,markContacted,genUncontacted,genAllLogs,mainMenu);

        Scene scene = new Scene(grid,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
