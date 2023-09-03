package classwork.chapter5;

import java.util.Scanner;

public class GlobalDoWhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chooseVariant;
        do {
            System.out.println("Enter '1' for a while loop or '2' for a do-while loop:");
            chooseVariant = scanner.nextInt();
        } while (chooseVariant != 1 && chooseVariant != 2);

        switch (chooseVariant){
            case 1 -> whileWithoutDo();
            case 2 -> doWhile();
        }
    }

     static void whileWithoutDo() {
        Scanner scanner = new Scanner(System.in);
        int value;

        do {
            System.out.println("Enter 5:");
            value = scanner.nextInt();
        } while (value != 5);

        System.out.println("You entered 5!");
    }

     static void doWhile() {
        Scanner scanner = new Scanner(System.in);
        int value;

        System.out.println("Enter 5:");
        value = scanner.nextInt();

        while (value != 5) {
            System.out.println("Enter 5:");
            value = scanner.nextInt();
        }

        System.out.println("You entered 5!");
    }
}
