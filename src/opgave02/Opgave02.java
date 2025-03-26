package opgave02;

import opgave02.models.Person;
import opgave02.models.SortedList;

import java.util.Iterator;

public class Opgave02 {
    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);

        Iterator<Integer> iterator = sortedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
