package homeworks.hm8Emplyoee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();
        int employeeID = 12345;

        boolean isRun = true;

        while (isRun) {

            System.out.println("""
                    1. To add employees:
                    2. To watch all employees:
                    3. To search employee by ID:
                    4. To search employee by company name:
                    5. To edit employee information:
                    0. To exit:
                    """);
            String selectVariant = scanner.nextLine();

            switch (selectVariant) {
                case "0":
                    isRun = false;
                    break;
                case "1":

                    System.out.println("Enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter the email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter the phone number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter the company name:");
                    String companyName = scanner.nextLine();
                    System.out.println("Enter the position:");
                    String position = scanner.nextLine();
                    System.out.println("Enter the salary:");
                    double salary = Double.parseDouble(scanner.nextLine());


                    if (!email.contains("@") || !email.contains("gmail") || !email.contains(".com")) {
                        System.out.println("Invalid email, please try again");
                    } else if (!phoneNumber.startsWith("+") && phoneNumber.length() != 13) {
                        System.out.println("Invalid phone number, please try again");
                    }

                    Employee employee = new Employee(employeeID, name, surname, email, phoneNumber, companyName, position, salary);
                    employeeStorage.add(employee);
                    employeeID++;
                    System.out.println("Employee is successfully added!");
                    break;

                case "2":

                    System.out.println("- - - - - - - - - -");
                    employeeStorage.print();
                    System.out.println("- - - - - - - - - -");
                    break;

                case "3":

                    System.out.println("Enter the ID:");
                    int foundEmployeeByID = Integer.parseInt(scanner.nextLine());
                    employeeStorage.searchBuyId(foundEmployeeByID);
                    break;

                case "4":

                    System.out.println("Enter the company name:");
                    String foundEmployeeByCompanyName = scanner.nextLine();
                    employeeStorage.searchBuyCompanyName(foundEmployeeByCompanyName);
                    break;

                case "5":
                    employeeStorage.edit();
                    break;

                default:
                    System.out.println("You are entered an error!");
            }
        }
    }
}
