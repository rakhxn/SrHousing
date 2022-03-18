package Project_1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Login {

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cus1156","root","password");
            return conn;
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    //creates the layout
    public static void display(Stage stage){
        AtomicBoolean loginCheck = new AtomicBoolean(false);
        //actual window surrounding the scene
        Stage window;
        window = stage;
        window.setTitle("SR. Housing");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label name = new Label("Username: ");
        GridPane.setConstraints(name,0,0);

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username"); // grayed out text prompting users to enter their username
        GridPane.setConstraints(nameInput,1,0);

        //Password label
        Label password = new Label("Password: ");
        GridPane.setConstraints(password,0,1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Login button
        Button login = new Button("Log In");
        login.setOnAction(e -> {
            try {
                loginCheck.set(Login.userExists(Objects.requireNonNull(Login.getConnection()),nameInput.getText(),passInput.getText()));
                if(loginCheck.get()){
                    MainWindow.display(stage);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //sets the layout together
        GridPane.setConstraints(login,1,2);
        grid.getChildren().addAll(name,nameInput,password,passInput,login);

        //casts the window with the scene in it
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }

    //checks to see if user exists
    public static Boolean userExists(Connection conn, String name, String password) throws Exception {
        boolean exists = false;
        String userResult = null;
        String passResult = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM employees WHERE username = '" + name +"';"
        );

        while (rs.next()) {
            userResult = rs.getString("username");
            passResult = rs.getString("password");
        }

        if(userResult == null || passResult == null){
            ErrorBox.display("Error!", "Try again!");
        }
        else if(userResult.equals(name.toLowerCase()) && passResult.equals(password)){
            System.out.println("Works!");
            exists = true;
        }
        else if(userResult.equals(name.toLowerCase()) && !passResult.equals(password)){
            System.out.println("Incorrect password!");
            ErrorBox.display("Error!", "Incorrect Password, try again!");
        }

        return exists;
    }
}
