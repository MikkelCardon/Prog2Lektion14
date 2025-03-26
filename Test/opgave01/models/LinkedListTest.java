package opgave01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<List> {
    LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }


    @Test
    void testOfLoadedConstructor() {
        //Opret linkedList
        linkedList = new LinkedList<>(new Integer[]{5, 8});
        //Sæt den i en ArrayList for at Assert
        ArrayList<Integer> actual = new ArrayList<>();
        linkedList.iterator().forEachRemaining(actual::add);
        //Expected
        ArrayList<Integer> expected = new ArrayList<>(java.util.List.of(5, 8));

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void addTest1() {
        linkedList.add(1);
        linkedList.add(2);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
    }

    @Test
    void addTestWithIndex() {
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(1,2);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    void addTestWithAddFirst() {
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(0,1);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    void addTestWithAddIndexEqualsSize() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(3,4);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        assertEquals(4, linkedList.get(3));
    }

    @Test
    void addTestWithAddIndexOutOfBounds() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1,4));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(linkedList.size()+1, 4));
    }

    @Test
    void removeElement() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove((Integer) 2);
        assertEquals(2, linkedList.size); //Assert size
        assertEquals(1, linkedList.get(0));
        assertEquals(3, linkedList.get(1));

        assertEquals(1, linkedList.head.element); //assert head
        assertEquals(3, linkedList.tail.element); //assert tail
    }

    @Test
    void removeFirstElement() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove((Integer) 1);
        assertEquals(2, linkedList.size); //Assert size
        assertEquals(2, linkedList.get(0));
        assertEquals(3, linkedList.get(1));

        assertEquals(2, linkedList.head.element); //assert head
        assertEquals(3, linkedList.head.next.element); //assert next

        assertEquals(3, linkedList.tail.element); //assert tail
        assertNull(linkedList.tail.next); //assert tail
    }

    @Test
    void removeLastElement() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove((Integer) 3);
        assertEquals(2, linkedList.size); //Assert size
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));

        assertEquals(1, linkedList.head.element); //assert head
        assertEquals(2, linkedList.head.next.element); //assert next

        assertEquals(2, linkedList.tail.element); //assert tail
        assertNull(linkedList.tail.next); //assert tail
    }

    @Test
    void addFirst() {
        linkedList.add(2);
        linkedList.add(3);

        linkedList.addFirst(1);

        assertEquals(3, linkedList.size);
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    void getFirst() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(linkedList.getFirst(), linkedList.head.element);
        assertEquals(1, linkedList.getFirst());
    }

    @Test
    void removeFirst() {
    }

    @Test
    void contains() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void get() {
    }

    @Test
    void getRecurssion() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void iterator() {
    }
}