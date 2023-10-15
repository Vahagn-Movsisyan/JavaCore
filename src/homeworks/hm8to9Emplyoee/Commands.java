package homeworks.hm8to9Emplyoee;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String WATCH_EMPLOYEE = "2";
    String SEARCH_EMPLOYEE_BY_ID = "3";
    String SEARCH_EMPLOYEE_BY_COMPANY = "4";
    String EDIT_EMPLOYEE = "5";

    String DELETE_EMPLOYEE = "6";

     static void printCommand() {
         System.out.println(ADD_EMPLOYEE + " To add employees:");
         System.out.println(WATCH_EMPLOYEE + " To watch all employees:");
         System.out.println(SEARCH_EMPLOYEE_BY_ID + " To search employee by ID:");
         System.out.println(SEARCH_EMPLOYEE_BY_COMPANY + " To search employee by company name:");
         System.out.println(EDIT_EMPLOYEE + " To edit employee information:");
         System.out.println(DELETE_EMPLOYEE + " Tp delete employee:");
         System.out.println(EXIT + " To exit:");
    }
}

