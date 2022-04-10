package Project_1.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QuarantineFunctions {
    public static void addResident(Stage stage){

        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label residentID = new Label("Resident ID: ");
        GridPane.setConstraints(residentID,0,0);
        TextField residentIDInput = new TextField();
        residentIDInput.setPromptText("resident id");
        GridPane.setConstraints(residentIDInput,1,0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        String startDate = dateFormat.format(c.getTime());
        c.add(Calendar.DATE, 5); // Adding 5 days to start date
        String endDate = dateFormat.format(c.getTime());

        Label dateStart = new Label("Date Start: ");
        GridPane.setConstraints(dateStart,0,1);
        TextField dateStartInput = new TextField();
        dateStartInput.setText(startDate);
        dateStartInput.setEditable(false);
        GridPane.setConstraints(dateStartInput,1,1);

        Label dateEnd = new Label("Date Start: ");
        GridPane.setConstraints(dateEnd,0,2);
        TextField dateEndInput = new TextField();
        dateEndInput.setText(endDate);
        dateEndInput.setEditable(false);
        GridPane.setConstraints(dateEndInput,1,2);

        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Quarantine.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,3);

        Button addQuarantine = new Button("Add");
        addQuarantine.setOnAction(e -> {
            //include addQuarantine Function
        });
        GridPane.setConstraints(addQuarantine,1,3);

        grid.getChildren().addAll(residentID,residentIDInput,dateStart,dateStartInput,dateEnd,dateEndInput,returnn,addQuarantine);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();





    }
}
