package opgave01.models;

public class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }
}
