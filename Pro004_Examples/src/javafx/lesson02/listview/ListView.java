package javafx.lesson02.listview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SimpleCalculator");

        Parent root = FXMLLoader.load(
                getClass().getResource("/javafx/lesson02/listview/view.fxml"));
        primaryStage.setScene(new Scene(root, 400, 300));

        primaryStage.show();
    }
}
