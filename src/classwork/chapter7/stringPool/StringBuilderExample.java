package classwork.chapter7.stringPool;

import java.util.Scanner;

public class StringBuilderExample {
    public static String txt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For using StringBuilder - '1' or usually - '2'");
        int selectVariant = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the text");
        txt = scanner.nextLine();

        switch (selectVariant) {
            case 1:
                useStringBuilder();
                break;
            case 2:
                useWithoutStringBuilder();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    static void useStringBuilder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines you want to append:");
        int enterCount = scanner.nextInt();

        StringBuilder stringBuilderResult = new StringBuilder(txt);
        for (int i = 0; i < enterCount; i++) {
            stringBuilderResult.append(i + 1);
        }

        System.out.println("Result using StringBuilder: " + stringBuilderResult);
    }

    static void useWithoutStringBuilder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines you want to append:");
        int enterCount = scanner.nextInt();

        for (int i = 0; i < enterCount; i++) {
            txt += (i + 1);
        }

        System.out.println("Result without using StringBuilder: " + txt);
    }
}
