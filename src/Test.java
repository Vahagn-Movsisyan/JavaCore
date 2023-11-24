public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 9, 4, 8};
//        sort(arr);
//        int number = 9;
//        System.out.println(factorial(number));
         dublicatElementFound(arr);
//        System.out.println(toFoundMaxElement(arr));
    }

    static int toFoundMaxElement(int[] arr) {
        int maxElement = 0;
        if (arr.length == 0) {
            System.out.println("Array is empty");
        }
        else {
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
