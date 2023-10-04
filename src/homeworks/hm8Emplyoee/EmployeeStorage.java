package homeworks.hm8Emplyoee;

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

    public void examEmail(String email) {
        if (!email.contains("@") || !email.contains("gmail") || !email.contains(".com")) {
            System.out.println("Invalid email, please try again");
        }
    }

    public void examPhoneNumber(String phoneNumber) {
        if (!phoneNumber.startsWith("+") && phoneNumber.length() != 13) {
            System.out.println("Invalid phone number, please try again");
        }
    }

    public void edit(int employeeID, String newInfo, String value) {
        boolean isEmployeeFound = false;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID() == employeeID) {
                isEmployeeFound = true;

                switch (newInfo) {
                    case "1":
                        employees[i].setName(value);
                        System.out.println("Name changed successfully.");
                        break;

                    case "2":
                        employees[i].setSurname(value);
                        System.out.println("Surname changed successfully.");
                        break;

                    case "3":
                        employees[i].setCompany(value);
                        System.out.println("Company name changed successfully.");
                        break;

                    case "4":
                        employees[i].setPosition(value);
                        System.out.println("Position changed successfully.");
                        break;

                    case "5":
                        double newSalary = Double.parseDouble(value);
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

