package homeworks.hm8to9Emplyoee.storage;

import homeworks.hm8to9Emplyoee.model.Employee;

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
        if (size >= 1) {
            for (int i = 0; i < size; i++) {
                printEmployee(employees[i]);
            }
        } else System.out.println("There are no current employees at the moment");
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

    public boolean examEmail(String email) {
        boolean isValidEmail = true;
        if (!email.contains("@") || !email.contains("gmail") || !email.contains(".com")) {
            System.out.println("Invalid email, please try again");
            isValidEmail = false;
        }
        return isValidEmail;
    }

    public boolean examPhoneNumber(String phoneNumber) {
        boolean isValidPhoneNumber = true;
        if (!phoneNumber.startsWith("+") && phoneNumber.length() != 13) {
            System.out.println("Invalid phone number, please try again");
            isValidPhoneNumber = false;
        }
        return isValidPhoneNumber;
    }

    public void deleteEmployee(int employeeID) {
        boolean isEmployeeFound = false;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID() == employeeID) {
                isEmployeeFound = true;

                for (int j = i; j < size - 1; j++) {
                    employees[i] = employees[i + 1];
                }

            }
        }
        employees[size - 1] = null;
        size--;

        if (!isEmployeeFound) System.out.println("Invalid employee ID");

    }

    public void edit(int employeeID, String choice, String newValue) {
        boolean isEmployeeFound = false;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID() == employeeID) {
                isEmployeeFound = true;

                switch (choice) {
                    case "1":
                        employees[i].setName(newValue);
                        System.out.println("Name changed successfully.");
                        break;

                    case "2":
                        employees[i].setSurname(newValue);
                        System.out.println("Surname changed successfully.");
                        break;

                    case "3":
                        employees[i].setCompany(newValue);
                        System.out.println("Company name changed successfully.");
                        break;

                    case "4":
                        employees[i].setPosition(newValue);
                        System.out.println("Position changed successfully.");
                        break;

                    case "5":
                        double newSalary = Double.parseDouble(newValue);
                        employees[i].setSalary(newSalary);
                        System.out.println("Salary changed successfully.");
                        break;

                    default:
                        System.out.println("Invalid information to edit.");
                        break;
                }
            }
        }

        if (!isEmployeeFound) {
            System.out.println("Employee with ID " + employeeID + " not found.");
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

