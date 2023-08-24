package classwork.chapter2;

import java.util.Scanner;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Example example = new Example();
        System.out.println("Welcome to FindNumber. To start, enter 'st'");
        String start = scanner.nextLine();

        switch (start) {
            case "st":
                System.out.println("Enter '>' if the number is greater, '<' if it's lesser, or '=' if guessed.");
                example.findNumber();
                break;
            default:
                System.out.println("You entered an error.");
        }

    }

    void findNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 1000;

        for (int i = 0; i < 10; i++) {

            int mid = random.nextInt(max - min + 1 ) + min;

            System.out.println("Is the number " + mid + "? Enter '>', '<', or '=':");
            String enter = scanner.nextLine();

            switch (enter) {
                case ">" -> min = mid + 1;
                case "<" -> max = mid - 1;
                case "=" -> {
                    System.out.println("Yay! I guessed your number.");
                    return;
                }
            }
        }
        System.out.println("I couldn't guess your number in 10 attempts. The correct number was:");
    }
}
