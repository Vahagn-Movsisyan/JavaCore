//public class Test {
//    int[] array = {2, 12, 8, 9, 34, 5};
//
//    public static void main(String[] args) {
//        Test test = new Test();
//        test.add(2, 99);
//
//    }
//
//    public  void  add(int index, int value) {
//        if (index <= array.length) {
//            for (int i = index; i < array.length - 1; i++) {
//                array[i] = array[i + 1];
//            }
//            array[index] = value;
//
//            for (int i = 0; i < array.length; i++) {
//                System.out.print(array[i] + " ");
//            }
//
//        } else {
//            System.out.println("Index isn't ina array");
//        }
//    }
//
//
//    void delete(int index) {
//      if (index <= array.length){
//          for (int i = index; i < array.length - 1; i++) {
//              array[i] = array[i + 1];
//          }
//          for (int i = 0; i < array.length - 1; i++) {
//              System.out.print(array[i] + " ");
//          }
//      }
//      else System.out.println("Index not in array");
//    }
//
//    public  int getBuyIndex(int value){
//        int i;
//        int count = 0;
//        for (i = 0; i < array.length ; i++) {
//            if (array[i] == value){
//                count++;
//            }
//        }
//        return -1;
//    }
//
//
//
//    public  void  set(int index, int value){
//        array[index] = value;
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//    }
//
//
//
//
//
//
//    public boolean exist(int value){
//        for (int i = 0; i < array.length; i++) {
//            if (value == array[i]) return true;
//        }
//        return false;
//    }
//
//}
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the employee ID to edit:");
//        int idEdit = Integer.parseInt(scanner.nextLine());
//        boolean employeeFound = false;
//
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getEmployeeID() == idEdit) {
//                employeeFound = true;
//
//                System.out.println("""
//                        1. Change Name:
//                        2. Change Surname:
//                        3. Change Company Name:
//                        4. Change Position:
//                        5. Change Salary:
//                        """);
//                String editEmployee = scanner.nextLine();
//
//                switch (editEmployee) {
//                    case "1":
//
//                        System.out.println("Enter the new name:");
//                        String newName = scanner.nextLine();
//                        employees[i].setName(newName);
//                        System.out.println("Name changed successfully.");
//                        break;
//
//                    case "2":
//
//                        System.out.println("Enter the new surname:");
//                        String newSurname = scanner.nextLine();
//                        employees[i].setSurname(newSurname);
//                        System.out.println("Surname changed successfully.");
//                        break;
//
//                    case "3":
//
//                        System.out.println("Enter the new company name:");
//                        String newCompanyName = scanner.nextLine();
//                        employees[i].setCompany(newCompanyName);
//                        System.out.println("Company name changed successfully.");
//                        break;
//
//                    case "4":
//
//                        System.out.println("Enter the new position:");
//                        String newPosition = scanner.nextLine();
//                        employees[i].setPosition(newPosition);
//                        System.out.println("Position changed successfully.");
//                        break;
//
//                    case "5":
//
//                        System.out.println("Enter the new salary:");
//                        double newSalary = Double.parseDouble(scanner.nextLine());
//                        employees[i].setSalary(newSalary);
//                        System.out.println("Salary changed successfully.");
//                        break;
//
//                    default:
//                        System.out.println("Invalid option. Please try again.");
//                        break;
//                }
//            }
//            if (!employeeFound) {
//                System.out.println("ID " + idEdit + " not found");
//            }
//        }
