package javafx.lesson04.tableviwex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableViewEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TableViewEx - JavaFX");
        Parent main = FXMLLoader.load(getClass().getResource("/javafx/lesson04/tableviewex/main.fxml"));
        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }
}
