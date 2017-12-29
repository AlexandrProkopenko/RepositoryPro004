package hwork.contacts.entity;

public class Contact {

    private String name;
    private String surname;
    private String date;
    private String phone;
    private String email;

    public Contact(String name, String surname, String date, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getDate() {
        return date;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
