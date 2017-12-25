package javafx.lesson02.calc.model;

public class CalculatorCPU {

    private Integer a;
    private Integer b;
    private String operation;

    public void setA(Integer a) {
        this.a = a;
    }
    public void setB(Integer b) {
        this.b = b;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer calculate() {
        switch (operation) {
            case "+" : {
                return a + b;
            }
            case "-" : {
                return a - b;
            }
            case "*" : {
                return a * b;
            }
            case "/" : {
                return a / b;
            }
            default:
                throw new RuntimeException();
        }
    }
}
