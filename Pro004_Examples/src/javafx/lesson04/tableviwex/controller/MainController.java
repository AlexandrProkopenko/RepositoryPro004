package javafx.lesson04.tableviwex.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.lesson04.tableviwex.entity.Employee;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class MainController {

    private ObservableList<Employee> employees;

    @FXML private TableView<Employee> tblEmloyees;

    @FXML private TableColumn<Employee, String> clnName;
    @FXML private TableColumn<Employee, String> clnSurname;
    @FXML private TableColumn<Employee, String> clnSalary;
    @FXML private TableColumn<Employee, String> clnPosition;
    @FXML private TableColumn<Employee, String> clnDepartment;

    @FXML private TextField fldName;
    @FXML private TextField fldSalary;
    @FXML private TextField fldSurname;
    @FXML private TextField fldPosiion;
    @FXML private TextField fldDepartment;

    @FXML
    private void initialize() {
        employees = FXCollections.observableArrayList();
        clnName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        clnSurname.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        clnSalary.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        clnPosition.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        clnDepartment.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        tblEmloyees.setItems(employees);
    }

    @FXML
    void btnAddOnClick(ActionEvent event) {
        employees.add(new Employee(
                fldName.getText(),
                fldSurname.getText(),
                fldSalary.getText(),
                fldPosiion.getText(),
                fldDepartment.getText()));
    }

    @FXML
    void btnUpdateOnClick(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnClick(ActionEvent event) {

    }

    @FXML
    void btnExitOnClick(ActionEvent event) {

    }

}
