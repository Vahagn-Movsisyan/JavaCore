package classwork.chapter14.collection;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        int number = 17;
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(number);
        System.out.println(numbers);
    }
}
