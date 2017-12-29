package hwork.contacts.controller;

import hwork.contacts.entity.Contact;
import hwork.contacts.service.FileService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {

    private ObservableList<Contact> contacts;
    private Contact selectedContact;

    @FXML private BorderPane mainWindow;

    @FXML private TextField fldName;
    @FXML private TextField fldSurname;
    @FXML private TextField fldDateOfBirth;
    @FXML private TextField fldPhone;
    @FXML private TextField fldEmail;

    @FXML private ListView<Contact> lstContacts;

    private FileChooser chooser;
    private File currentFile;

    @FXML
    private void initialize() {
        contacts = FXCollections.observableArrayList();
        lstContacts.setItems(contacts);

        chooser = new FileChooser();
    }

    @FXML
    private void lstContactsOnMouseClicked() {
        selectedContact = lstContacts.getSelectionModel().getSelectedItem();
        fldName.setText(selectedContact.getName());
        fldSurname.setText(selectedContact.getSurname());
        fldDateOfBirth.setText(selectedContact.getDate());
        fldPhone.setText(selectedContact.getPhone());
        fldEmail.setText(selectedContact.getEmail());
    }

    @FXML
    private void mnuNewFileOnClick() {
        contacts = FXCollections.observableArrayList();
    }

    @FXML
    private void mnuOpenFileOnClick() {
        currentFile = chooser.showOpenDialog(mainWindow.getScene().getWindow());
        contacts = FileService.openContactsFile(currentFile);
        lstContacts.setItems(contacts);
        lstContacts.refresh();
    }

    @FXML
    private void mnuSaveFileOnClick() {
        if (currentFile != null) {
            FileService.saveContactsFile(currentFile, contacts);
        } else {
            currentFile = chooser.showSaveDialog(mainWindow.getScene().getWindow());
            FileService.saveContactsFile(currentFile, contacts);
        }
    }

    @FXML
    private void mnuSaveAsFileOnClick() {
        currentFile = chooser.showSaveDialog(mainWindow.getScene().getWindow());
        FileService.saveContactsFile(currentFile, contacts);
    }

    @FXML
    private void mnuExitFileOnClick() {
        System.exit(0);
    }

    @FXML
    private void btnNewOnClick() {
        contacts.add(new Contact(
                fldName.getText(),
                fldSurname.getText(),
                fldDateOfBirth.getText(),
                fldPhone.getText(),
                fldEmail.getText()
        ));
        fldClear();
    }

    @FXML
    private void btnSaveOnClick() {
        selectedContact.setName(fldName.getText());
        selectedContact.setSurname(fldSurname.getText());
        selectedContact.setDate(fldDateOfBirth.getText());
        selectedContact.setPhone(fldPhone.getText());
        selectedContact.setEmail(fldEmail.getText());
        lstContacts.refresh();
        fldClear();
    }

    @FXML
    private void btnDeleteOnClick() {
        contacts.remove(selectedContact);
        fldClear();
    }

    @FXML
    private void btnExitOnClick() {
        System.exit(0);
    }

    private void fldClear() {
        fldName.clear();
        fldSurname.clear();
        fldDateOfBirth.clear();
        fldPhone.clear();
        fldEmail.clear();
    }
}
