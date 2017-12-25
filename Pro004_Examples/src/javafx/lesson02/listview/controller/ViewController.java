package javafx.lesson02.listview.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.lesson02.listview.entity.Node;
import javafx.scene.control.ListView;

public class ViewController {

    private ObservableList<Node> nodes;

    @FXML private ListView<Node> lstElements;

    @FXML
    private void initialize() {
        nodes = FXCollections.observableArrayList();
        nodes.add(new Node("NodeN1", "NodeS1"));
        nodes.add(new Node("NodeN2", "NodeS2"));
        nodes.add(new Node("NodeN3", "NodeS3"));
        lstElements.setItems(nodes);
    }
}
