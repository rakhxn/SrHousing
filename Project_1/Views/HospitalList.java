package Project_1.Views;

import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HospitalList {
    public static void displayMain(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);

        //ADD RESIDENT TO MISSED MEAL LIST
        Button addResident = new Button("Add Resident");
        addResident.setOnAction(e -> {
           HospitalListFunctions.addResident(stage);
        });
        GridPane.setConstraints(addResident,0,0);

        //MARK RESIDENT CONTACTED
        Button returnResident = new Button("Return Resident");
        returnResident.setOnAction(e -> {
            HospitalListFunctions.returnResident(stage);
        });
        GridPane.setConstraints(returnResident,0,1);

        //GENERATE UNCONTACTED LOGS
        Button genCurrent = new Button("Generate Current List");
        genCurrent.setOnAction(e -> {
            //include generate nurse logs
        });
        GridPane.setConstraints(genCurrent,0,2);

        //GENERATE ALL LOGS
        Button genAllLogs = new Button("Generate All Logs");
        genAllLogs.setOnAction(e -> {
            //include generate maintenance function
        });
        GridPane.setConstraints(genAllLogs,0,3);


        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e ->{
            View.displayMain(stage);
        });
        GridPane.setConstraints(mainMenu,0,4);

        grid.getChildren().addAll(addResident,returnResident,genCurrent,genAllLogs,mainMenu);

        Scene scene = new Scene(grid,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
