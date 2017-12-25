package javafx.lesson02.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SimpleCalculator");
        primaryStage.setResizable(false);

        Parent root = FXMLLoader.load(
                getClass().getResource("/javafx/lesson02/calc/view/main.fxml"));
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }
}
