import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
//        sort(arr);
//        int number = 9;
//        System.out.println(factorial(number));
//         dublicatElementFound(arr);
//        System.out.println(toFoundMaxElement(arr));
//        reversedArray(arr);
//        System.out.println(foundSimpleNumbers(arr));
        for (int i : twoSum(arr, 6)) {
            if (i != -1) {
                System.out.println(i + " ");
            } else {
                System.out.println("no");
            }
        }
    }


    static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int foundSimpleNumbers(int[] arr) {
        int countPrimeNumbers = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                countPrimeNumbers++;
            }
        }
        return countPrimeNumbers;
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
       return true;
    }

    static void reversedArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    static int toFoundMaxElement(int[] arr) {
        int maxElement = 0;
        if (arr.length == 0) {
            System.out.println("Array is empty");
        } else {
            for (int i : arr) {
                if (i > maxElement) {
                    maxElement = i;
                }
            }
        }
        return maxElement;
    }

    static void dublicatElementFound(int[] arr) {
        boolean isDublicate = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    isDublicate = true;
                }
            }
        }
        if (!isDublicate) {
            System.out.println("isn't dublicate");
        }
    }

    static int factorial(int number) {
        int tmpNumber = 1;
        for (int i = 1; i <= number; i++) {
            tmpNumber *= i;
        }
        return tmpNumber;
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
