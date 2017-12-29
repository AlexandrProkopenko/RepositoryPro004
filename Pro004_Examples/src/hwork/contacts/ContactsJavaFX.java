package hwork.contacts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactsJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ContactsBook - JavaFX");
        primaryStage.setResizable(false);

        Parent main = FXMLLoader.load(getClass().getResource("/hwork/contacts/view/main.fxml"));

        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContactsJavaFX.class, args);
    }
}
