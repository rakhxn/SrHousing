package Project_1.Views;

import Project_1.Connector;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ResidentsFunctions {
    public static void addResident (Stage stage){

        // DEFINES THE SIZE OF BOX
        stage.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label firstName = new Label("First Name: ");
        GridPane.setConstraints(firstName,0,0);
        TextField firstNameInput = new TextField();
        firstNameInput.setPromptText("first name");
        GridPane.setConstraints(firstNameInput,1,0);

        Label lastName = new Label("Last Name: ");
        GridPane.setConstraints(lastName,0,1);
        TextField lastNameInput = new TextField();
        lastNameInput.setPromptText("last name");
        GridPane.setConstraints(lastNameInput,1,1);

        Label unit = new Label("Unit #: ");
        GridPane.setConstraints(unit,0,2);
        TextField unitInput = new TextField();
        unitInput.setPromptText("unit");
        GridPane.setConstraints(unitInput,1,2);


        Label emergencyContact = new Label("Emergency Contact #: ");
        GridPane.setConstraints(emergencyContact,0,3);
        TextField emergencyContactInput = new TextField();
        emergencyContactInput.setPromptText("emergency contact");
        GridPane.setConstraints(emergencyContactInput,1,3);

        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Residents.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,4);

        Button addResident = new Button("Add Resident");
        addResident.setOnAction(e -> {
            //include add resident function
        });
        GridPane.setConstraints(addResident,1,4);

        grid.getChildren().addAll(firstName,firstNameInput,lastName,lastNameInput,unit,unitInput,emergencyContact,emergencyContactInput,addResident,returnn);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void removeResident(Stage stage){
        stage.setTitle("Sr. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label residentId = new Label("Resident Id: ");
        GridPane.setConstraints(residentId,0,0);
        TextField residentIdInput = new TextField();
        residentIdInput.setPromptText("resident id");
        GridPane.setConstraints(residentIdInput,1,0);


        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Residents.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,1);


        Button remove = new Button("Remove");
        remove.setOnAction(e -> {
            //include remove function
        });
        GridPane.setConstraints(remove,1,1);

        grid.getChildren().addAll(residentId,residentIdInput,returnn,remove);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void updateResident(Stage stage){
        AtomicInteger integerValue = new AtomicInteger();
        int x =0;
        stage.setTitle("Sr. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label residentId = new Label("Resident ID: ");
        GridPane.setConstraints(residentId,0,0);
        TextField residentIdInput = new TextField();
        residentIdInput.setPromptText("resident id");
        GridPane.setConstraints(residentIdInput,1,0);

        Button returnn = new Button("Return");
        returnn.setOnAction(e -> {
            Residents.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,1);

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            try {
                getResidentID(stage, Objects.requireNonNull(Connector.getConnection()),Integer.parseInt(residentIdInput.getText()));
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Exception : "+ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(submit,1,1);

        grid.getChildren().addAll(residentId,residentIdInput,returnn,submit);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void getResidentID(Stage stage, Connection conn, int residentID) throws Exception {
        stage.setTitle("Sr. Housing");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        String fName = null;
        String lName = null;
        String unit = null;
        String emergencyContact = null;

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM residents WHERE resident_id = '" + residentID +"';"
        );

        while (rs.next()) {
            fName = rs.getString("firstname");
            lName = rs.getString("lastname");
            unit = rs.getString("unit");
            emergencyContact = rs.getString("emergencycontact");
        }

        Label resident_ID = new Label("Resident ID: ");
        GridPane.setConstraints(resident_ID,0,0);
        TextField resident_IDInput = new TextField();
        resident_IDInput.setEditable(false);
        resident_IDInput.setText(String.valueOf(residentID));
        GridPane.setConstraints(resident_IDInput,1,0);


        Label firstName = new Label("First Name: ");
        GridPane.setConstraints(firstName,0,1);
        TextField firstNameInput = new TextField();
        firstNameInput.setText(fName);
        GridPane.setConstraints(firstNameInput,1,1);

        Label lastName = new Label("Last Name: ");
        GridPane.setConstraints(lastName,0,2);
        TextField lastNameInput = new TextField();
        lastNameInput.setText(lName);
        GridPane.setConstraints(lastNameInput,1,2);

        Label Unit = new Label("Unit #: ");
        GridPane.setConstraints(Unit,0,3);
        TextField UnitInput = new TextField();
        UnitInput.setText(unit);
        GridPane.setConstraints(UnitInput,1,3);

        Label eContact = new Label("Emergency Contact #: ");
        GridPane.setConstraints(eContact,0,4);
        TextField eContactInput = new TextField();
        eContactInput.setText(emergencyContact);
        GridPane.setConstraints(eContactInput,1,4);

        Button returnn = new Button("Return");
        returnn.setOnAction(e ->{
            Residents.displayMain(stage);
        });
        GridPane.setConstraints(returnn,0,5);

        Button update = new Button("Update");
        update.setOnAction(e -> {

        });
        GridPane.setConstraints(update,1,5);

        grid.getChildren().addAll(resident_ID,resident_IDInput,firstName,firstNameInput,lastName,lastNameInput,Unit,UnitInput,eContact,eContactInput,returnn,update);


        Scene scene = new Scene(grid,300,250);
        stage.setScene(scene);
        stage.show();

    }


}
