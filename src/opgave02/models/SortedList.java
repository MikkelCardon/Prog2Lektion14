package opgave02.models;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedList<E extends Comparable<E>> implements SortedListEaaa<E>{
    Node<E> head;
    Node<E> tail;
    int size;

    public SortedList(){
    }

    public SortedList(E[] data) {
        for (E d : data) {
            add(d);
        }
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }else if(e.compareTo(head.element) < 0){
            newNode.next = head;
            head = newNode;
        } else if (e.compareTo(tail.element) > 0) {
            tail.next = newNode;
            tail = newNode;
        }else{ //Insert middle
            Node<E> node1 = head;
            Node<E> node2 = head.next;

            while(node2 != null && e.compareTo(node2.element) > 0){
                node1 = node2;
                node2 = node2.next;
            }
            node1.next = newNode;
            newNode.next = node2;
        }
        size++;
    }

    @Override
    public boolean remove(E e) {
        Node<E> previousNode = null;
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.element.equals(e)){
                if (previousNode == null){
                    removeFirst();
                } else if (currentNode == tail) {
                    tail = previousNode;
                    previousNode.next = null;
                    size--;
                } else{
                    previousNode.next = currentNode.next;
                    size--;
                }
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.element.equals(e)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFirst() {
        return head.element;
    }

    @Override
    public void removeFirst() {
        if (size == 0){
            throw new NoSuchElementException("No such element");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else{
            head = head.next;
            size--;
            if (head == null){
                tail = null;
            }
        }
    }

    @Override
    public E getLast() {
        return tail.element;
    }

    @Override
    public void removeLast() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        if (size == 1){
            removeFirst();
            return;
        }

        Node<E> previousNode = null;
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode == tail){
                tail = previousNode;
                previousNode.next = null;
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()){
                    throw new NoSuchElementException("No such element");
                }
                E temp = currentNode.element;
                currentNode = currentNode.next;
                return temp;
            }
        };
    }
}
