package homeworks.hm4SortAlgoritms;

import java.util.Scanner;

public class SortingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortingArray sortingArray = new SortingArray();

        System.out.println("Enter the sort - '1' or revers sort - '2'");
        int selectVariant = scanner.nextInt();

        switch (selectVariant){
            case 1 -> sortingArray.sortArray();
            case 2 -> sortingArray.sortReversArray();
            default -> System.out.println("You are an entered an error");
        }
    }
}
