package opgave01.models;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListEaaa<E>{
    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList(){
    }

    public LinkedList(E[] data) {
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
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E e) {
        Node<E> previousNode = null;
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.element == e){
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
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null){
            tail = newNode;
        }
    }

    @Override
    public E getFirst() {
        return head.element;
    }

    @Override
    public E removeFirst() {
        if (size == 0){
           return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = null;
            tail = null;
            size--;
            return temp.element;
        } else{
            Node<E> tempHead = head;
            head = head.next;
            size--;
            if (head == null){
                tail = null;
            }
            return tempHead.element;
        }
    }

    @Override
    public boolean contains(E e) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.element == e){
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
        if(head == null && tail == null && size == 0){
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index >= size) return null;
        return getRecurssion(index, 0, head);
    }


    public E getRecurssion(int index, int currentIndex, Node<E> currentNode) {
        if(index == currentIndex){
            return currentNode.element;
        }
        return getRecurssion(index, currentIndex+1, currentNode.next);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) addFirst(e);
        else if (index == size) add(e);
        else{
            Node<E> currentNode = head;
            for (int i = 1; i < size; i++) {
                if (i == index){
                Node<E> newNode = new Node<>(e);
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                size++;
                return;
                }
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index == 0){
            return removeFirst();
        }
        else{
            Node<E> currentNode = head;
            Node<E> previousNode = null;
            for (int i = 0; i < size; i++) {
                if (i == index){
                    if (index == size-1){
                        previousNode.next = null;
                        tail = previousNode;
                        return currentNode.element;
                    }
                    previousNode.next = currentNode.next;
                    size--;
                    return currentNode.element;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            return null;
        }
    }

    @Override
    public int indexOf(E e) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if(currentNode.element == e){
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()){
                    throw new NoSuchElementException("Has no next");
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
