package javafx.lesson02.listview.entity;

public class Node {

    private String nodeName;
    private String nodeSurname;

    public Node(String nodeName, String nodeSurname) {
        this.nodeName = nodeName;
        this.nodeSurname = nodeSurname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeName='" + nodeName + '\'' +
                ", nodeSurname='" + nodeSurname + '\'' +
                '}';
    }
}
