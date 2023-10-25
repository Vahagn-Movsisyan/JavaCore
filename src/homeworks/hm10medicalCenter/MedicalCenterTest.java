package homeworks.hm10medicalCenter;

import homeworks.hm10medicalCenter.exeptions.notFoundExceptions.NotFoundPersonException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation.DoubleEmailFoundException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation.IncorrectFormatEmailException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation.DoublePhoneNumberFoundException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation.InvalidPhoneNumberFormatException;
import homeworks.hm10medicalCenter.model.Doctor;
import homeworks.hm10medicalCenter.model.Patient;
import homeworks.hm10medicalCenter.storage.MedicalCenterStorage;
import homeworks.hm10medicalCenter.util.DateUtil;


import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterTest implements Commands {
    static Scanner scanner = new Scanner(System.in);
    static MedicalCenterStorage medicalCenterStorage = new MedicalCenterStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;

        while (isRun) {

            Commands.printCommands();
            String selectVariant = scanner.nextLine();

            switch (selectVariant) {
                case EXIT -> isRun = false;
                case ADD_DOCTOR -> addDoctor();
                case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
                case DELETE_DOCTOR_BY_ID -> deleteDoctor();
                case CHANGE_DOCTOR_BT_ID -> changeDoctorByIDMetod();
                case ADD_PATIENT -> addPatient();
                case PRINT_PATIENTS_BY_DOCTOR -> printPatientByDoctorID();
                case PRINT_ALL_PATIENTS -> printAllPatients();
                case PRINT_ALL_DOCTORS -> printAllDoctors();
            }
        }
    }

    private static void changeDoctorByIDMetod() {
        System.out.println("Enter the doctor ID");
        String enterDoctorID = scanner.nextLine();

        System.out.println("""
                1. Change doctor ID:
                2. Change Name:
                3. Change Surname:
                4. Change email:
                5. Change phone number:
                6. Change profession:
                """);
        String choice = scanner.nextLine();

        System.out.println("Enter the new value");
        String newValue = scanner.nextLine();

        medicalCenterStorage.changeDoctorByID(enterDoctorID, choice, newValue);

    }

    private static void deleteDoctor() {
        System.out.println("Enter teh doctor ID");
        String enterDoctorID = scanner.nextLine();

        medicalCenterStorage.deleteDoctorByID(enterDoctorID);
        System.out.println("Doctor successfully deleted");
    }

    private static void printAllPatients() {
        try {
            System.out.println("--------------------");
            medicalCenterStorage.printAllPatients();
            System.out.println("--------------------");
        } catch (NullPointerException e) {
            System.out.println("Error: in patient information, please check datetime");
        }
    }

    private static void printAllDoctors() {
        System.out.println("--------------------");
        medicalCenterStorage.printAllDoctors();
        System.out.println("--------------------");
    }

    private static void printPatientByDoctorID() {
        System.out.println("Enter the doctor ID");
        String doctorID = scanner.nextLine();

        medicalCenterStorage.searchPatientsByDoctorId(doctorID);
    }

    private static void addPatient() {

        String patientEmail;
        String patientPhoneNumber;

        System.out.println("Enter the ID of the doctor you want to register with");
        medicalCenterStorage.printAllDoctors();
        String doctorID = scanner.nextLine();

        try {
            medicalCenterStorage.getDoctorByID(doctorID);
        } catch (NotFoundPersonException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Enter patient card ID:");
        String patientCardID = scanner.nextLine();

        boolean exist;

        try {
            medicalCenterStorage.getPatientCardByID(patientCardID);
            exist = true;
        } catch (NotFoundPersonException e) {
            exist = false;
        }

        if (!exist) {
            System.out.println("Enter patient name:");
            String patientName = scanner.nextLine();

            System.out.println("Enter patient surname:");
            String patientSurname = scanner.nextLine();

            System.out.println("Enter patient email:");
            patientEmail = scanner.nextLine();

            try {
                medicalCenterStorage.examEmail(patientEmail);
            } catch (DoubleEmailFoundException | IncorrectFormatEmailException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter patient phone number:");
            patientPhoneNumber = scanner.nextLine();

            try {
                medicalCenterStorage.examPhoneNumber(patientPhoneNumber);
            } catch (InvalidPhoneNumberFormatException | DoublePhoneNumberFoundException e) {
                System.out.println(e.getMessage());
            }

            Date date;
            String registerDate;

            try {
                System.out.println("Enter the date in format(dd/mm/yyyy hh:mm)");
                registerDate = scanner.nextLine();
                medicalCenterStorage.isAvailableDateTime(doctorID, registerDate);

                if (!medicalCenterStorage.isAvailableDateTime(doctorID, registerDate)) {
                    System.out.println("DateTime isn't available, please try another datetime.");
                    return;
                }

                date = DateUtil.stringToDate(registerDate);

            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in the correct format (dd/mm/yyyy hh:mm)");
                return;
            }

            Patient patient = new Patient(patientCardID, patientName, patientSurname, patientPhoneNumber, patientEmail, doctorID, date);
            medicalCenterStorage.add(patient);
            System.out.println("Patient is successfully added!");
        }

    }

    private static void addDoctor() {

        System.out.println("Enter the doctor ID");
        String doctorID = scanner.nextLine();

        boolean exist;

        try {
            medicalCenterStorage.getDoctorByID(doctorID);
            exist = true;
        } catch (NotFoundPersonException e) {
            exist = false;
        }

        if (!exist) {
            System.out.println("Enter the name:");
            String name = scanner.nextLine();
            System.out.println("Enter the surname:");
            String surname = scanner.nextLine();

            System.out.println("Enter the email:");
            String email = scanner.nextLine();

            try {
                medicalCenterStorage.examEmail(email);
            } catch (DoubleEmailFoundException | IncorrectFormatEmailException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter the phone number:");
            String phoneNumber = scanner.nextLine();

            try {
                medicalCenterStorage.examPhoneNumber(phoneNumber);
            } catch (InvalidPhoneNumberFormatException | DoublePhoneNumberFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter the profession name:");
            String doctorProfession = scanner.nextLine();

            Doctor doctor = new Doctor(name, surname, phoneNumber, email, doctorProfession, doctorID);
            medicalCenterStorage.add(doctor);
            System.out.println("Doctor is successfully added!");
        } else {
            System.out.println(doctorID + " id already exist");
        }
    }

    private static void searchDoctorByProfession() {
        System.out.println("Enter the doctor profession");
        String enterDoctorProfession = scanner.nextLine();
        medicalCenterStorage.searchDoctorByProfession(enterDoctorProfession);
    }
}

