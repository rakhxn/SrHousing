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

public class MissedMealFunctions {
    public static void addMissedMeal(Stage stage){
        stage.setTitle("SR. Housing");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label id = new Label("Request ID: ");
        TextField idInput = new TextField();
        idInput.setText("");
        idInput.setEditable(false);
        GridPane.setConstraints(id,0,0);
        GridPane.setConstraints(idInput,1,0);

        Label residentID = new Label("Resident ID: ");
        TextField residentIDInput = new TextField();
        residentIDInput.setPromptText("resident id");
        GridPane.setConstraints(residentID,0,1);
        GridPane.setConstraints(residentIDInput,1,1);

        Label mealType = new Label("Meal Missed:");
        ChoiceBox<String> mealTypeInput = new ChoiceBox<>();
        mealTypeInput.getItems().add("Nurse");
        mealTypeInput.getItems().add("Maintenance");
        mealTypeInput.setValue("Select One");
        GridPane.setConstraints(mealType,0,2);
        GridPane.setConstraints(mealTypeInput,1,2);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date: ");
        TextField dateInput = new TextField();
        dateInput.setText(String.valueOf(dateOnly));
        dateInput.setEditable(false);
        GridPane.setConstraints(date,0,3);
        GridPane.setConstraints(dateInput,1,3);


        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            MissedMeal.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,4);

        Button add = new Button("Add");
        add.setOnAction(e -> {
            //include update function
        });
        GridPane.setConstraints(add,1,4);

       grid.getChildren().addAll(id,idInput,residentID,residentIDInput,mealType,mealTypeInput,date,dateInput,returnn,add);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    private static String getChoice(ChoiceBox<String> choiceBox){
        return choiceBox.getValue();
    }

    public static void markContacted(Stage stage) {
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label requestID = new Label("Request ID:");
        TextField requestIDInput = new TextField();
        requestIDInput.setPromptText("request id");
        GridPane.setConstraints(requestID, 0, 0);
        GridPane.setConstraints(requestIDInput, 1, 0);

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        Label date = new Label("Date Completed: ");
        TextField dateTime = new TextField();
        dateTime.setText(String.valueOf(dateOnly));
        dateTime.setEditable(false);
        GridPane.setConstraints(date, 0, 1);
        GridPane.setConstraints(dateTime, 1, 1);

        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Requests.displayMain(stage);
        });
        GridPane.setConstraints(returnn, 0, 2);

        Button update = new Button("Update");
        update.setOnAction(e -> {
            //include update function
        });
        GridPane.setConstraints(update, 1, 2);

        grid.getChildren().addAll(requestID, requestIDInput, date, dateTime, returnn, update);

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
