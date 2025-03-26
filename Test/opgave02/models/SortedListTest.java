package opgave02.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedListTest {
    private SortedList<Integer> sortedList;
    @BeforeEach
    void setUp() {
        sortedList = new SortedList<>();
    }

    @Test
    void add() {
        sortedList.add(2);
        sortedList.add(1); //Test of new head
        sortedList.add(3); //Test if new tail

        assertEquals(1, sortedList.head.element);
        assertEquals(2, sortedList.head.next.element);
        assertEquals(3, sortedList.tail.element);
    }

    @Test
    void addInTheMiddle() {
        sortedList.add(1);
        sortedList.add(4);

        sortedList.add(3);
        sortedList.add(2);

        assertEquals(2, sortedList.head.next.element);
        assertEquals(4, sortedList.size);
    }
}