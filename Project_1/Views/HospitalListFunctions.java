package Project_1.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HospitalListFunctions {
    public static void addResident(Stage stage){
        stage.setTitle("SR. Housing");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label residentID = new Label("Resident ID: ");
        TextField residentIDInput = new TextField();
        residentIDInput.setPromptText("resident id");
        GridPane.setConstraints(residentID,0,0);
        GridPane.setConstraints(residentIDInput,1,0);

        Label hospitalName = new Label("Hospital Name: ");
        TextField hospitalNameInput = new TextField();
        hospitalNameInput.setPromptText("hospital name");
        GridPane.setConstraints(hospitalName,0,1);
        GridPane.setConstraints(hospitalNameInput,1,1);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date: ");
        TextField dateInput = new TextField();
        dateInput.setText(String.valueOf(dateOnly));
        dateInput.setEditable(false);
        GridPane.setConstraints(date,0,2);
        GridPane.setConstraints(dateInput,1,2);


        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            MissedMeal.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,3);

        Button add = new Button("Add");
        add.setOnAction(e -> {
            //include update function
        });
        GridPane.setConstraints(add,1,3);

        grid.getChildren().addAll(residentID,residentIDInput,hospitalName,hospitalNameInput,date,dateInput,returnn,add);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void returnResident(Stage stage){
        stage.setTitle("SR. Housing");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label residentID = new Label("Resident ID: ");
        TextField residentIDInput = new TextField();
        residentIDInput.setPromptText("resident id");
        GridPane.setConstraints(residentID,0,0);
        GridPane.setConstraints(residentIDInput,1,0);

        Label covidStatus = new Label("Covid Status: ");
        ChoiceBox<String> covidStatusInput = new ChoiceBox<>();
        covidStatusInput.getItems().add("True");
        covidStatusInput.getItems().add("False");
        covidStatusInput.setValue("Select One");
        GridPane.setConstraints(covidStatus,0,1);
        GridPane.setConstraints(covidStatusInput,1,1);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date: ");
        TextField dateInput = new TextField();
        dateInput.setText(String.valueOf(dateOnly));
        dateInput.setEditable(false);
        GridPane.setConstraints(date,0,2);
        GridPane.setConstraints(dateInput,1,2);


        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            MissedMeal.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,3);

        Button add = new Button("Add");
        add.setOnAction(e -> {
            //include update function
        });
        GridPane.setConstraints(add,1,3);

        grid.getChildren().addAll(residentID,residentIDInput,covidStatus,covidStatusInput,date,dateInput,returnn,add);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    private static String getChoice(ChoiceBox<String> choiceBox){
        return choiceBox.getValue();
    }
}