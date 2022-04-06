package Project_1;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        View.displayLogin(stage);
    }

}