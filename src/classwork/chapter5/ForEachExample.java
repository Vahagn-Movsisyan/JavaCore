package classwork.chapter5;
import java.util.Scanner;

public class ForEachExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {7, 1, 5, 2, 9, 3};
        boolean found = false;
        int foundEnter = 0;

        System.out.println("Enter the number to find in the array:");
        foundEnter = scanner.nextInt();

        for (int elementFound : numbers) {
            if (elementFound == foundEnter) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Number " + foundEnter + " is in the array.");
        } else {
            System.out.println("Number " + foundEnter + " is not in the array.");
        }
    }
}
