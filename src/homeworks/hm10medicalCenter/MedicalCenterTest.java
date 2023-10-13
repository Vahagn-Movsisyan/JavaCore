package homeworks.hm10medicalCenter;

import homeworks.hm10medicalCenter.model.Doctor;
import homeworks.hm10medicalCenter.model.Patient;
import homeworks.hm10medicalCenter.storage.MedicalCenterStorage;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterTest {

    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static MedicalCenterStorage medicalCenterStorage = new MedicalCenterStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;

        while (isRun) {

            printCommands();
            String selectVariant = scanner.nextLine();

            switch (selectVariant) {
                case "0" -> isRun = false;
                case "1" -> addDoctor();
                case "2" -> searchDoctorByProfession();
                case "3" -> deleteDoctor();
                case "4" -> changeDoctorByIDMetod();
                case "5" -> addPatient();
                case "6" -> printPatientByDoctorID();
                case "7" -> printAllPatients();
                case "8" -> printAllDoctors();
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
        System.out.println("--------------------");
        medicalCenterStorage.printAllPatients();
        System.out.println("--------------------");
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

    private static void addPatient() throws ParseException {

        boolean isValidPatientEmail;
        boolean isValidPatientPhoneNumber;

        String patientEmail;
        String patientPhoneNumber;

        System.out.println("Enter the ID of the doctor you want to register with");
        medicalCenterStorage.printAllDoctors();
        String doctorID = scanner.nextLine();

        Doctor doctorFromStorage = medicalCenterStorage.getDoctorByID(doctorID);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with ID " + doctorID + " does not exist");
            return;
        }

        System.out.println("Enter patient card ID:");
        String patientCardID = scanner.nextLine();

        System.out.println("Enter patient name:");
        String patientName = scanner.nextLine();

        System.out.println("Enter patient surname:");
        String patientSurname = scanner.nextLine();

       do {
           System.out.println("Enter patient email:");
           patientEmail = scanner.nextLine();

           medicalCenterStorage.examEmail(patientEmail);
           isValidPatientEmail = medicalCenterStorage.examEmail(patientEmail);

       } while (!isValidPatientEmail);

       do {
           System.out.println("Enter patient phone number:");
           patientPhoneNumber = scanner.nextLine();

           medicalCenterStorage.examPhoneNumber(patientPhoneNumber);
           isValidPatientPhoneNumber = medicalCenterStorage.examPhoneNumber(patientPhoneNumber);

       } while (!isValidPatientPhoneNumber);

        System.out.println("Enter the date in format(dd/mm/yyyy)");
        String registerDate = scanner.nextLine();

        Date date = simpleDateFormat.parse(registerDate);

        Patient patient = new Patient(patientCardID, patientName, patientSurname, patientPhoneNumber, patientEmail, doctorID, registerDate);
        medicalCenterStorage.addPatient(patient);
        System.out.println("Patient is successfully added!");
    }

   private static void addDoctor() {
       boolean isValidEmail;
       boolean isValidPhoneNumber;

       String email;
       String phoneNumber;

       System.out.println("Enter the doctor ID");
       String doctorID = scanner.nextLine();

       System.out.println("Enter the name:");
       String name = scanner.nextLine();
       System.out.println("Enter the surname:");
       String surname = scanner.nextLine();

       do {
           System.out.println("Enter the email:");
           email = scanner.nextLine();
           medicalCenterStorage.examEmail(email);
           isValidEmail = medicalCenterStorage.examEmail(email);

       } while (!isValidEmail);

       do {
           System.out.println("Enter the phone number:");
           phoneNumber = scanner.nextLine();
           medicalCenterStorage.examPhoneNumber(phoneNumber);
           isValidPhoneNumber = medicalCenterStorage.examPhoneNumber(phoneNumber);
       } while (!isValidPhoneNumber);


       System.out.println("Enter the profession name:");
       String doctorProfession = scanner.nextLine();

       Doctor doctor = new Doctor(name, surname, phoneNumber, email, doctorProfession, doctorID);
       medicalCenterStorage.addDoctor(doctor);
       System.out.println("Doctor is successfully added!");
   }

   private static void searchDoctorByProfession() {
       System.out.println("Enter the doctor profession");
       String enterDoctorProfession = scanner.nextLine();
       medicalCenterStorage.searchDoctorByProfession(enterDoctorProfession);
   }

    private static void printCommands() {
        System.out.println("""
                0 - exit:
                1 - add doctor:
                2 - search doctor by profession:
                3 - delete doctor by id:
                4 - change doctor by id:
                5 - add patient:
                6 - print all patients by doctor:
                7 - print all patients:
                8 - print all doctors:
                """);
    }
}

