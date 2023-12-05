import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 5, 9, 1, 7, 3, 5, 6};
        int number = 9;
        String name = "poxos";
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("carr", 8);
        map.put("box", 9);


//        sort(arr);
        foundDublicateNumbers(arr);
//        System.out.println(factorial(number));
//         dublicatElementFound(arr);
//        System.out.println(toFoundMaxElement(arr));
//        reversedArray(arr);
//        System.out.println(foundSimpleNumbersCounts(arr));
//        System.out.println(foundNumberCount(arr, 5));
//        insertionSort(arr);
//        System.out.println(countElementsArray(arr));
//        System.out.println(countFactorialNumber(1));
//        foundPrimeNumbers(arr);
//        printPrimeNumbers1to100();
//        deleteIndex(arr, 9);
//        System.out.println(toFoundMaxElement(arr));
//        printKeySet(map);
//        for (int i : reversNumber(561236542)) {
//            System.out.print(i);
//        }
//        for (String s : reversLine(name)) {
//            System.out.print(s);
//        }
//        for (int i : twoSum(arr, 6)) {
//            if (i != -1) {
//                System.out.println(i + " ");
//            } else {
//                System.out.println("no");
//            }
//        }
    }


    static void printKeySet (Map<String, Integer> map) {
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    static void deleteIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }

    static int[] reversNumber(int number) {
        String numberToStr = Integer.toString(number);
        int[] tmp = new int[numberToStr.length()];
        for (int i = numberToStr.length() - 1; i >= 0; i--) {
            tmp[numberToStr.length() - i - 1] = Character.getNumericValue(numberToStr.charAt(i));
        }
        return tmp;
    }

    static String[] reversLine(String line) {
        String[] tmp = new String[line.length()];
        for (int i = line.length() - 1; i >= 0; i--) {
            tmp[line.length() - i - 1] = Character.toString(line.charAt(i));
        }
        return tmp;
    }

    static void printPrimeNumbers1to100() {
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static void foundPrimeNumbers(int[] arr) {
        boolean isPrime = false;
        for (int j : arr) {
            if (isPrime(j)) {
                System.out.print(j + " ");
                isPrime = true;
            }
        }
        if (!isPrime) {
            System.out.println("Prime numbers isn't found!");
        }
    }

    static int countFactorialNumber(int number) {
        int tmpNumber = 1;
        if (number == 0) {
            return 0;
        }
        for (int i = 1; i <= number; i++) {
            tmpNumber *= i;
        }
        return tmpNumber;
    }

    static int countElementsArray(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    static int foundNumberCount(int[] arr, int number) {
        int count = 0;
        for (int j : arr) {
            if (j == number) {
                count++;
            }
        }
        return count;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int foundSimpleNumbersCount(int[] arr) {
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
            System.out.print(arr[i]);
        }
    }

    static int toFoundMaxElement(int[] arr) {
        int maxElement = arr[0];
        for (int i : arr) {
            if (i > maxElement) {
                maxElement = i;
            }
        }
        return maxElement;
    }

    static void foundDublicateNumbers(int[] arr) {
        boolean isDublicate = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    isDublicate = true;
                }
            }
        }

        if (!isDublicate) {
            System.out.print("No");
        }
    }

    static int factorial(int number) {
        int tmpNumber = 1;
        for (int i = 1; i <= number; i++) {
            tmpNumber *= i;
        }
        return tmpNumber;
    }

    static void sort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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
