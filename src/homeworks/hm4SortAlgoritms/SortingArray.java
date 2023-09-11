package homeworks.hm4SortAlgoritms;

import java.util.Scanner;

public class SortingArray {
    public void sortArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers by spase");
        String enterNum = scanner.nextLine();

        String[] numbers = enterNum.split(" ");
        int[] realNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            realNumbers[i] = Integer.parseInt(numbers[i]);
        }

        sort(realNumbers);

    }

    public void sortReversArray(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers by spase");
        String enterNum = scanner.nextLine();

        String[] numbers = enterNum.split(" ");
        int[] realNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            realNumbers[i] = Integer.parseInt(numbers[i]);
        }

        reversSort(realNumbers);
    }
    private void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]){
                    int changeElement = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = changeElement;
                }
            }
        }
        for (int printNum : array){
            System.out.print(printNum + " ");
        }
    }

    private void reversSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j+1]){
                    int changeElement = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = changeElement;
                }
            }
        }
        for (int printNum : array){
            System.out.print(printNum + " ");
        }
    }
}
