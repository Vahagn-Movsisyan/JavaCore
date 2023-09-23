package homeworks.hm5DynamicArray;

import java.util.Scanner;

public class DynamicArrayTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArray dynamicArray = new DynamicArray();

        int select;
        do {
            System.out.println("""
                    To start adding elements to the array, select '1':
                    To exit enter '2':
                    """);
            select = scanner.nextInt();
            scanner.nextLine();
        } while (select < 1 || select > 2);

        switch (select) {
            case 1:
                int addElementsCount;
                do {
                    System.out.println("How many elements do you want to add (up to 20)?");
                    addElementsCount = scanner.nextInt();
                    scanner.nextLine();
                } while (addElementsCount > 20);

                for (int i = 0; i < addElementsCount; i++) {
                    System.out.println("Enter element " + (i + 1) + ":");
                    int addingElement = scanner.nextInt();
                    scanner.nextLine();
                    dynamicArray.add(addingElement);
                }

                System.out.println("The elements in the array:");
                dynamicArray.print();

                System.out.println("""
                         Options:
                         1. Check index
                         2. Delete element at index
                         3. Change element at index
                         4. Add element at index
                         5. Examine an element in the array
                         6. Examine elements more than a certain value in the array
                        """);
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter the index you want to check: ");
                        int checkIndex = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(dynamicArray.getByIndex(checkIndex));
                        break;
                    case 2:
                        System.out.println("Enter the index you want to delete: ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        dynamicArray.deleteByIndex(deleteIndex);
                        break;
                    case 3:
                        System.out.println("Enter the index:");
                        int enterChangeIndex = scanner.nextInt();
                        System.out.println("Enter the value:");
                        int enterChangeElement = scanner.nextInt();
                        dynamicArray.set(enterChangeIndex, enterChangeElement);
                        break;
                    case 4:
                        System.out.println("Enter the index:");
                        int enterAddIndex = scanner.nextInt();
                        System.out.println("Enter the value");
                        int enterAddValue = scanner.nextInt();
                        dynamicArray.add(enterAddIndex, enterAddValue);
                        break;
                    case 5:
                        System.out.println("Enter the value to exam:");
                        int examValue = scanner.nextInt();
                        System.out.println(dynamicArray.exists(examValue));
                        break;
                    case 6:
                        System.out.println("Enter the value to exam:");
                        int examDoubleValue = scanner.nextInt();
                        System.out.println(dynamicArray.getIndexByValue(examDoubleValue));
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
                break;
            case 2:
                System.out.println("You are successfully exited...");
                break;
            default:
                System.err.println("Invalid option.");
        }
    }
}
