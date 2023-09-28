package homeworks.hm7braceChecker;

import java.util.Scanner;

public class BraceCheckerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the line - ");
        String text = scanner.nextLine();

        BraceChecker braceChecker = new BraceChecker(text);
        braceChecker.check();


    }
}
