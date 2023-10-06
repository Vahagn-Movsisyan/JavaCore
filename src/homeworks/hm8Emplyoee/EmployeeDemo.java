package homeworks.hm8Emplyoee;

import java.util.Scanner;

public class EmployeeDemo {

    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();
    static int employeeID = 12345;

    public static void main(String[] args) {


        boolean isRun = true;

        while (isRun) {

            printCommand();
            String selectVariant = scanner.nextLine();

            switch (selectVariant) {
                case "0" -> isRun = false;
                case "1" -> addEmployee();
                case "2" -> printAllEmployees();
                case "3" -> foundEmployeeByID();
                case "4" -> foundEmployeeByCompanyName();
                case "5" -> editMetod();
                case "6" -> deleteEmployeeMetod();
                default -> System.out.println("You are an entered an error!");
            }
        }
    }

    private static void deleteEmployeeMetod() {
        System.out.println("Enter the employee ID, for delete");
        int employeeIdDelete = Integer.parseInt(scanner.nextLine());

        employeeStorage.deleteEmployee(employeeIdDelete);
        System.out.println("Employee successfully deleted");

    }

    private static void editMetod() {
        System.out.println("Enter the employee ID to edit:");
        int idEdit = Integer.parseInt(scanner.nextLine());

        System.out.println("""
                1. Change Name:
                2. Change Surname:
                3. Change Company Name:
                4. Change Position:
                5. Change Salary:
                """);

        String editEmployeeChoice = scanner.nextLine();

        System.out.println("Enter the new value:");
        String newValue = scanner.nextLine();

        employeeStorage.edit(idEdit, editEmployeeChoice, newValue);
    }


    private static void foundEmployeeByCompanyName() {
        System.out.println("Enter the company name:");
        String foundEmployeeByCompanyName = scanner.nextLine();
        employeeStorage.searchBuyCompanyName(foundEmployeeByCompanyName);
    }

    private static void foundEmployeeByID() {
        System.out.println("Enter the ID:");
        int foundEmployeeByID = Integer.parseInt(scanner.nextLine());
        employeeStorage.searchBuyId(foundEmployeeByID);
    }

    private static void printAllEmployees() {
        System.out.println("- - - - - - - - - -");
        employeeStorage.print();
        System.out.println("- - - - - - - - - -");
    }

    private static void addEmployee() {
        boolean isValidEmail;
        boolean isValidPhoneNumber;

        String email;
        String phoneNumber;

        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();

        //Exam email
        do {
            System.out.println("Enter the email:");
            email = scanner.nextLine();
            employeeStorage.examEmail(email);
            isValidEmail = employeeStorage.examEmail(email);

        } while (!isValidEmail);


        //Exam phone number
        do {
            System.out.println("Enter the phone number:");
            phoneNumber = scanner.nextLine();
            employeeStorage.examPhoneNumber(phoneNumber);
            isValidPhoneNumber = employeeStorage.examPhoneNumber(phoneNumber);
        } while (!isValidPhoneNumber);


        System.out.println("Enter the company name:");
        String companyName = scanner.nextLine();
        System.out.println("Enter the position:");
        String position = scanner.nextLine();
        System.out.println("Enter the salary:");
        double salary = Double.parseDouble(scanner.nextLine());

        Employee employee = new Employee(employeeID, name, surname, email, phoneNumber, companyName, position, salary);
        employeeStorage.add(employee);
        employeeID++;
        System.out.println("Employee is successfully added!");
    }

    private static void printCommand() {
        System.out.println("""
                1. To add employees:
                2. To watch all employees:
                3. To search employee by ID:
                4. To search employee by company name:
                5. To edit employee information:
                6. Tp delete employee:
                0. To exit:
                """);
    }
}
