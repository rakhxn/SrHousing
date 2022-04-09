package Project_1;
import Project_1.Views.RequestsFunctions;
import Project_1.Views.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        View.displayLogin(stage);
    }

}