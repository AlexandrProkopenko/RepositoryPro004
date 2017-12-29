package hwork.contacts.service;

import hwork.contacts.entity.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Scanner;

public class FileService {

    public static ObservableList<Contact> openContactsFile(File fileName) {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                String[] params = sc.nextLine().split(" ");
                contacts.add(new Contact(
                        params[0],
                        params[1],
                        params[2],
                        params[3],
                        params[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static void saveContactsFile(File fileName, ObservableList<Contact> contacts) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Contact contact : contacts) {
                fw.write(contact.getName()    + " " +
                             contact.getSurname() + " " +
                             contact.getDate()    + " " +
                             contact.getPhone()   + " " +
                             contact.getEmail()   + "\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
