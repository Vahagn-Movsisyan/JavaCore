package homeworks.hm3arrayUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        System.out.println("All elements in array");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        System.out.println("First element an array");
        System.out.println(numbers[0]);

        System.out.println("Last element in array");
        int lastIndex = numbers.length - 1;
        System.out.println(numbers[lastIndex]);


        System.out.println("Array length");
        System.out.println(numbers.length);

        System.out.println("Smaller number in array");
        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }
        System.out.println(minNumber);

        System.out.println("Printing mid elements");
        if (numbers.length <= 2) {
            System.out.println("Can't print middle values");
        } else if (numbers.length % 2 != 0) {
            int midIndex = numbers.length / 2;
            int midElement = numbers[midIndex];
            System.out.println("The mid element is " + midElement);
        } else {

            int midIndex1 = numbers.length / 2 - 1;
            int midIndex2 = numbers.length / 2;
            int midElement1 = numbers[midIndex1];
            int midElement2 = numbers[midIndex2];
            System.out.println("The mid elements are " + midElement1 + " and " + midElement2);
        }

        System.out.println("Printing counts of even numbers in array");
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);

        System.out.println("Printing counts of odd numbers in array");
        int oddCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddCount++;
            }
        }
        System.out.println(oddCount);

        System.out.println("Printing sum of all elements in array");
        int sumElements = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumElements += numbers[i];
        }
        System.out.println(sumElements);

        System.out.println("Printing the arithmetic mean elements in array");
        double sum = 0;
        double arithmeticMean;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        arithmeticMean = (double) sum / numbers.length;
        System.out.println(arithmeticMean);
    }
}
