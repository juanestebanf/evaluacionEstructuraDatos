package examen;

public class Node<T> {

    T data;
    Node<T> next; // siguiente nodo
    Node<T> prev; // nodo anterior

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}