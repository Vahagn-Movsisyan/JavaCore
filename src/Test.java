public class Test {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1;  j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int sortArray : array) {
            System.out.print(sortArray + " ");
        }
    }
}
