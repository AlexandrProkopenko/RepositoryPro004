package javafx.lesson01.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML private TextField fldLogin;
    @FXML private TextField fldPassword;

    @FXML
    public void buttonSingUpOnClick() {
        System.out.println("Login : " + fldLogin.getText());
        System.out.println("Password : " + fldPassword.getText());
    }

    @FXML
    public void buttonCancelOnClick() {
        System.exit(0);
    }
}
