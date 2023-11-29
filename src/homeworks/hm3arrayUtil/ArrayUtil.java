package homeworks.hm3arrayUtil;
public class ArrayUtil {
    int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

    public void getAllElement(int[] numbers) {
        System.out.println("All elements in array");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public void getFirstElement(int[] numbers) {
        System.out.println("First element in array");
        System.out.println(numbers[0]);
    }


    public void getLastElement(int[] numbers) {
        System.out.println("Last element in array");
        int lastIndex = numbers.length - 1;
        System.out.println(numbers[lastIndex]);
    }

    public void getArrayLength(int[] numbers) {
        System.out.println("Array length");
        System.out.println(numbers.length);
    }

    public void getSmallestNumber(int[] numbers) {
        System.out.println("Smallest number in array");
        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }
        System.out.println(minNumber);
    }

    public void printMidElements(int[] numbers) {
        System.out.println("Printing middle elements");
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
    }

    public void getCountEvenNumbers(int[] numbers) {
        System.out.println("Counting even numbers in array");
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);
    }

    public void getCountOddNumbers(int[] numbers) {
        System.out.println("Counting odd numbers in array");
        int oddCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddCount++;
            }
        }
        System.out.println(oddCount);
    }

    public void getSumAllElements(int[] numbers) {
        System.out.println("Sum of all elements in array");
        int sumElements = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumElements += numbers[i];
        }
        System.out.println(sumElements);
    }

    public void getCalculateArithmeticMean(int[] numbers) {
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
