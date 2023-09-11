package homeworks.hm3arrayUtil;

import java.util.Scanner;

public class ArrayUtilTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        int selectVariant;

       do {
           System.out.println("""
                   1 - all elements
                   2 - first element
                   3 - last element
                   4 - array length
                   5 - smallest number
                   6 - mid numbers
                   7 - count even
                   8 - count odd
                   9 - sum
                   10 - arithmetic mean
                   """);
           selectVariant = scanner.nextInt();
       } while (selectVariant < 1 || selectVariant > 10);

       switch (selectVariant){
           case 1 -> arrayUtil.getAllElement(numbers);
           case 2 -> arrayUtil.getFirstElement(numbers);
           case 3 -> arrayUtil.getLastElement(numbers);
           case 4 -> arrayUtil.getArrayLength(numbers);
           case 5 -> arrayUtil.getSmallestNumber(numbers);
           case 6 -> arrayUtil.printMidElements(numbers);
           case 7 -> arrayUtil.getCountEvenNumbers(numbers);
           case 8 -> arrayUtil.getCountOddNumbers(numbers);
           case 9 -> arrayUtil.getSumAllElements(numbers);
           case 10 -> arrayUtil.getCalculateArithmeticMean(numbers);
       }
    }
}
