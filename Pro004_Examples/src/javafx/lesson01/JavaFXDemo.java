package javafx.lesson01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo");
        Parent main = FXMLLoader.load(
                getClass().getResource("/javafx/lesson01/view.fxml")
        );
        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
