package homeworks.hm8Emplyoee;

import java.util.Scanner;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size;

    public void add(Employee employee) {
        if (employees.length == size) {
            extend();
        }
        employees[size++] = employee;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            printEmployee(employees[i]);
        }
    }

    public void searchBuyId(int employeeID) {
        boolean isTestID = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID() == employeeID) {
                printEmployee(employees[i]);
                isTestID = true;

            }
        }
        if (!isTestID) System.out.println("ID " + employeeID + " not found");
    }

    public void searchBuyCompanyName(String companyName) {
        boolean isTestCompanyName = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().contains(companyName)) {
                printEmployee(employees[i]);
                isTestCompanyName = true;
            }
        }
        if (!isTestCompanyName) System.out.println("Company name " + companyName + " not found");
    }

    public void edit() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the employee ID to edit:");
        int idEdit = Integer.parseInt(scanner.nextLine());
        boolean employeeFound = false;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID() == idEdit) {
                employeeFound = true;

                System.out.println("""
                        1. Change Name:
                        2. Change Surname:
                        3. Change Company Name:
                        4. Change Position:
                        5. Change Salary:
                        """);
                String editEmployee = scanner.nextLine();

                switch (editEmployee) {
                    case "1":

                        System.out.println("Enter the new name:");
                        String newName = scanner.nextLine();
                        employees[i].setName(newName);
                        System.out.println("Name changed successfully.");
                        break;

                    case "2":

                        System.out.println("Enter the new surname:");
                        String newSurname = scanner.nextLine();
                        employees[i].setSurname(newSurname);
                        System.out.println("Surname changed successfully.");
                        break;

                    case "3":

                        System.out.println("Enter the new company name:");
                        String newCompanyName = scanner.nextLine();
                        employees[i].setCompany(newCompanyName);
                        System.out.println("Company name changed successfully.");
                        break;

                    case "4":

                        System.out.println("Enter the new position:");
                        String newPosition = scanner.nextLine();
                        employees[i].setPosition(newPosition);
                        System.out.println("Position changed successfully.");
                        break;

                    case "5":

                        System.out.println("Enter the new salary:");
                        double newSalary = Double.parseDouble(scanner.nextLine());
                        employees[i].setSalary(newSalary);
                        System.out.println("Salary changed successfully.");
                        break;

                    default:
                        System.out.println("You are an entered an error");
                        break;
                }
            }
            if (!employeeFound) {
                System.out.println("ID " + idEdit + " isn't found");
            }
        }
    }

    private void printEmployee(Employee employee) {
        System.out.println("Employee Information:");
        System.out.println("ID: " + employee.getEmployeeID());
        System.out.println("Name: " + employee.getName());
        System.out.println("Surname: " + employee.getSurname());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("Company: " + employee.getCompany());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println();
    }


    private void extend() {
        Employee[] tempArray = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tempArray, 0, employees.length);
        employees = tempArray;
    }
}
