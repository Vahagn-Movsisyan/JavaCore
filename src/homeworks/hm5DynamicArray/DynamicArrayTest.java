package homeworks.hm5DynamicArray;

import java.util.Scanner;

public class DynamicArrayTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArray dynamicArray = new DynamicArray();
        int select;

        do {
            System.out.println("""
                    To adding elements in array select '1':
                    To see if there is a subscripted index into the array and in which element '2':
                    """);
            select = scanner.nextInt();
            scanner.nextLine();

        } while (select < 1 || select > 2);

        switch (select){
            case 1:
                int addElementsCount;
               do {
                   System.out.println("How many element you want to add up to 20?");
                   addElementsCount = scanner.nextInt();
                   scanner.nextLine();
               } while (addElementsCount > 20);

                for (int i = 0; i < addElementsCount ; i++) {
                    System.out.println("Enter the " + (i + 1) + " element");
                    int addingElement = scanner.nextInt();
                    scanner.nextLine();
                    dynamicArray.add(addingElement);
                }

                System.out.println("The elements in array:");
                dynamicArray.print();

                System.out.println();

                System.out.println("Do you want to check index Now? 'yes' or 'no'");
                String selectYesOrNo = scanner.nextLine();


                switch (selectYesOrNo){
                    case "yes":
                        System.out.println("Enter the index what you want to check: ");
                        int checkIndex = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(dynamicArray.getByIndex(checkIndex));
                        break;
                    case "no":
                        System.out.println("You are an entered an no exit...");
                        break;
                    default:
                        System.out.println("You are an entered an error");
                }

                break;

            case 2:
                System.out.println("Enter the index what you want to check: ");
                int checkIndex = scanner.nextInt();
                scanner.nextLine();
                System.out.println(dynamicArray.getByIndex(checkIndex));
                break;
            default:
                System.err.println("You are an entered an error:");
        }
    }
}
