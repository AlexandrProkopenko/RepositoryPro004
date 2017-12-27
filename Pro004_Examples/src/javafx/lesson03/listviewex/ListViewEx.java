package javafx.lesson03.listviewex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListViewEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListViewEx - JavaFX");
        primaryStage.setResizable(false);

        Parent main = FXMLLoader.load(
                getClass().getResource("/javafx/lesson03/view.fxml")
        );

        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }
}
