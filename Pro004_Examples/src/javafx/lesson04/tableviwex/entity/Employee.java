package javafx.lesson04.tableviwex.entity;

public class Employee {

    private String name;
    private String surname;
    private String salary;
    private String position;
    private String department;

    public Employee(String name, String surname, String salary, String position, String department) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
