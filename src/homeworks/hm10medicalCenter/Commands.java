package homeworks.hm10medicalCenter;

public interface Commands {

    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BT_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_PATIENTS_BY_DOCTOR = "6";
    String PRINT_ALL_PATIENTS = "7";
    String PRINT_ALL_DOCTORS = "8";


    static void printCommands() {
        System.out.println(EXIT + " - exit");
        System.out.println(ADD_DOCTOR + " - add doctor");
        System.out.println(SEARCH_DOCTOR_BY_PROFESSION + " - search doctor by profession");
        System.out.println(DELETE_DOCTOR_BY_ID + " - delete doctor by id");
        System.out.println(CHANGE_DOCTOR_BT_ID + " - change doctor by id");
        System.out.println(ADD_PATIENT + " - add patient");
        System.out.println(PRINT_PATIENTS_BY_DOCTOR + " - print all patients by doctor");
        System.out.println(PRINT_ALL_PATIENTS + " - print all patients");
        System.out.println(PRINT_ALL_DOCTORS + " - print all doctors");
    }
}
