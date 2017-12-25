package javafx.lesson02.calc.controller;

import javafx.fxml.FXML;
import javafx.lesson02.calc.model.CalculatorCPU;
import javafx.scene.control.TextField;

public class MainViewController {

    private CalculatorCPU cpu;

    @FXML private TextField fldA;
    @FXML private TextField fldB;
    @FXML private TextField fldResult;

    @FXML
    private void initialize() {
        cpu = new CalculatorCPU();
    }

    @FXML
    private void add() {
        cpu.setA(Integer.parseInt(fldA.getText()));
        cpu.setB(Integer.parseInt(fldB.getText()));
        cpu.setOperation("+");
        fldResult.setText(Integer.toString(cpu.calculate()));
    }

    @FXML
    private void sub() {
        cpu.setA(Integer.parseInt(fldA.getText()));
        cpu.setB(Integer.parseInt(fldB.getText()));
        cpu.setOperation("-");
        fldResult.setText(Integer.toString(cpu.calculate()));
    }

    @FXML
    private void mul() {
        cpu.setA(Integer.parseInt(fldA.getText()));
        cpu.setB(Integer.parseInt(fldB.getText()));
        cpu.setOperation("*");
        fldResult.setText(Integer.toString(cpu.calculate()));
    }

    @FXML
    private void div() {
        cpu.setA(Integer.parseInt(fldA.getText()));
        cpu.setB(Integer.parseInt(fldB.getText()));
        cpu.setOperation("/");
        fldResult.setText(Integer.toString(cpu.calculate()));
    }
}
