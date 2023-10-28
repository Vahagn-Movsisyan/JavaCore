package classwork.chapter12.enumExampels;

import java.util.Scanner;

public class UserEnumTest {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        register();
    }

    static void register() {
        Language[] languages = Language.values();

        System.out.println("Enter username");
        String username = scanner.nextLine();

        System.out.println("Enter password");
        String password = scanner.nextLine();

        System.out.println("Available languages");
        for (Language language : languages) {
            System.out.println(language + " " + language.getLanguageName());
        }

        Language language = null;
        boolean exist;

        try {
            System.out.println("Enter the language");
            language = Language.valueOf(scanner.nextLine().toUpperCase());
            exist = true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid language");
            exist = false;
        }

        if (!exist) {
            for (int i = 0; i < 4; i++) {
                try {
                    System.out.println("Enter the available languages");
                    language = Language.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Enter the available languages " + (i + 1));
                    language = Language.valueOf(scanner.nextLine().toUpperCase());
                }
            }
        }
        User user = new User(username, password, language);
    }
}
