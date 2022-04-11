package Project_1.Views;

import Project_1.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Requests {
    public static void displayMain(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);

        //CREATE REQUEST BUTTON
        Button createRequest = new Button("Create Request");
        createRequest.setOnAction(e -> {
            RequestsFunctions.createRequest(stage);
        });
        GridPane.setConstraints(createRequest,0,0);

        //MARK REQUEST COMPLETE
        Button markComplete = new Button("Mark Request Completed");
        markComplete.setOnAction(e -> {
            RequestsFunctions.markCompleted(stage);
        });
        GridPane.setConstraints(markComplete,0,1);


        //CREATE PENDING NURSE REQUEST
        Button pendingNurseRequest = new Button("Pending Nurse Requests");
        pendingNurseRequest.setOnAction(e -> {
            //include pending nurse request function
        });
        GridPane.setConstraints(pendingNurseRequest,0,2);

        //CREATE PENDING MAINTENANCE REQUEST
        Button pendingMaintenanceRequest = new Button("Pending Maintenance Request");
        pendingMaintenanceRequest.setOnAction(e -> {
            //include pending nurse request function
        });
        GridPane.setConstraints(pendingMaintenanceRequest,0,3);

        //GENERATE NURSE LOGS
        Button genNurseLogs = new Button("Generate Nurse Logs");
        genNurseLogs.setOnAction(e -> {
            //include generate nurse logs
        });
        GridPane.setConstraints(genNurseLogs,0,4);

        //GENERATE MAINTENANCE LOGS
        Button genMaintenanceLogs = new Button("Generate Maintenance Logs");
        genMaintenanceLogs.setOnAction(e -> {
            //include generate maintenance function
        });
        GridPane.setConstraints(genMaintenanceLogs,0,5);


        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e ->{
            try {
                View.displayMain(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(mainMenu,0,6);

        grid.getChildren().addAll(createRequest,pendingNurseRequest,pendingMaintenanceRequest,genNurseLogs,genMaintenanceLogs,markComplete,mainMenu);

        Scene scene = new Scene(grid,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
