package homeworks.hm2ForArrayExamples;

import java.util.Scanner;

public class ForExamples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Hi!!
                if you want to see all the numbers 1-1000 with beautiful symbols enter '1':
                if you want to see all the even numbers 1-100 enter 'even' or 'odd' to odd numbers:
                if you want to see largest number in the array enter 'max' or 'min' to smaller:
                """);
        String selectVariant = scanner.nextLine();

        switch (selectVariant){
            case "1" -> numbersUpTo1000();
            case "even" -> evenNumbers();
            case "odd" -> oddNumbers();
            case "max" -> findMaxNumber();
            case "min" -> findMinNumber();
            default -> System.out.println("You are entered an error");
        }
    }

    static void numbersUpTo1000(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are selected a numbers 1-1000 by beautiful symbols, enter symbol");
        String symbol = scanner.nextLine();

        for (int i = 1; i <= 1000; i++) {
            System.out.print(i + symbol);
            if (i == 999){
                System.out.print("1000");
                break;
            }
        }
    }

    static void evenNumbers(){
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }

    static void oddNumbers(){
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.print(i + " ");
            }
        }
    }

    static void findMaxNumber(){
        int[] numbers = {2,5,8,4,9,3,7};

        int maxNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        System.out.println("The largest number in array is - " + maxNumber);
    }

    static void findMinNumber(){
        int[] numbers = {11,5,8,4,9,3,7};

        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }
        System.out.println("The smaller number in array is - " + minNumber);
    }
}

