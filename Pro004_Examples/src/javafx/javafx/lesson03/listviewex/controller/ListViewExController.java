package javafx.lesson03.listviewex.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lesson03.listviewex.entity.User;


public class ListViewExController {

    private ObservableList<User> users;
    private User currentUser;

    @FXML private TextField fldLogin;
    @FXML private TextField fldPassword;

    @FXML private ListView<User> lstUsers;

    @FXML
    private void initialize() {
        users = FXCollections.observableArrayList();
        lstUsers.setItems(users);
    }

    @FXML
    private void buttonAddOnClick() {
        users.add(new User(
                fldLogin.getText(),
                fldPassword.getText()));
        fldLogin.clear(); fldPassword.clear();
    }

    @FXML
    private void selectionUser() {
        currentUser = lstUsers
                .getSelectionModel()
                .getSelectedItem();

        fldLogin.setText(currentUser.getLogin());
        fldPassword.setText(currentUser.getPassword());
    }

    @FXML
    private void buttonUpdateOnClick() {
        currentUser.setLogin(fldLogin.getText());
        currentUser.setPassword(fldPassword.getText());
        lstUsers.refresh();
    }

    @FXML
    private void buttonDeleteOnClick() {
        users.remove(currentUser);
        fldLogin.clear(); fldPassword.clear();
    }
}
