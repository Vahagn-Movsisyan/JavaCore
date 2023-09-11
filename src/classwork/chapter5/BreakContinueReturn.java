package classwork.chapter5;

import java.io.FilterOutputStream;

public class BreakContinueReturn {
    public static void main(String[] args) {
        int[] array = {3, 9, 1, 5, 2, 8, 6, 7};
        for (int temp : array) {
            System.out.print(temp + " ");
            if (temp % 2 == 0) continue;

            System.out.println("-");
        }
    }
}
