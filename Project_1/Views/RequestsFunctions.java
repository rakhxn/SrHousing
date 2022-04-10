package Project_1.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RequestsFunctions {
    public static void createRequest(Stage stage){
        stage.setTitle("SR. Housing");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        // REQUEST TYPE //
        Label type = new Label("Request Type: ");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Nurse");
        choiceBox.getItems().add("Maintenance");
        choiceBox.setValue("Select One");
        GridPane.setConstraints(type,0,0);
        GridPane.setConstraints(choiceBox,1,0);

        // RESIDENT ID //
        Label residentID = new Label("Resident ID: ");
        TextField residentIDInput = new TextField();
        residentIDInput.setPromptText("resident id");
        GridPane.setConstraints(residentID,0,1);
        GridPane.setConstraints(residentIDInput,1,1);

        // DESCRIPTION //
        Label descrp = new Label("Description: ");
        TextArea descrpInput = new TextArea();
        descrpInput.setPrefHeight(100);
        descrpInput.setPrefWidth(200);
        GridPane.setConstraints(descrp,0,2);
        GridPane.setConstraints(descrpInput,1,2);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date Requested: ");
        TextField dateTime = new TextField();
        dateTime.setText(String.valueOf(dateOnly));
        dateTime.setEditable(false);
        GridPane.setConstraints(date,0,3);
        GridPane.setConstraints(dateTime,1,3);


        Button returnn = new Button("Return");
        returnn.setOnAction(e ->{
            Requests.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,5);


        Button create = new Button("Create Request");
        create.setOnAction(e ->{
            System.out.println(choiceBox.getValue());
        });
        GridPane.setConstraints(create,1,5);


        grid.getChildren().addAll(type,choiceBox,residentID,residentIDInput,descrp,descrpInput,date,dateTime,returnn,create);

        Scene scene = new Scene(grid,300,250);
        stage.setScene(scene);
        stage.show();
    }

    public static void markCompleted(Stage stage){
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label requestID = new Label("Request ID:");
        TextField requestIDInput = new TextField();
        requestIDInput.setPromptText("request id");
        GridPane.setConstraints(requestID,0,0);
        GridPane.setConstraints(requestIDInput,1,0);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date Completed: ");
        TextField dateTime = new TextField();
        dateTime.setText(String.valueOf(dateOnly));
        dateTime.setEditable(false);
        GridPane.setConstraints(date,0,1);
        GridPane.setConstraints(dateTime,1,1);

        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Requests.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,2);

        Button update = new Button("Update");
        update.setOnAction(e -> {
            //include update function
        });
        GridPane.setConstraints(update,1,2);

        grid.getChildren().addAll(requestID,requestIDInput,date,dateTime,returnn,update);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }
}