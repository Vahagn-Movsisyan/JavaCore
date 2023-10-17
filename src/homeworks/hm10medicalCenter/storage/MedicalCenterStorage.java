package homeworks.hm10medicalCenter.storage;

import homeworks.hm10medicalCenter.model.Doctor;
import homeworks.hm10medicalCenter.model.Patient;
import homeworks.hm10medicalCenter.model.Person;
import homeworks.hm10medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;


public class MedicalCenterStorage {

    Person[] persons = new Person[10];

    private int size;

    public void add(Person person) {
        if (size == persons.length) {
            extend();
        }
        persons[size++] = person;
    }

    public void printAllDoctors() {
        boolean isEmpty = false;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor && size >= 1){
                System.out.println(persons[i]);
                isEmpty = true;
            }
        }
        if (!isEmpty) {
            System.out.println("No doctor at the moment");
        }
    }

    public void printAllPatients() {
       boolean isEmpty = false;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient && size >= 1){
                System.out.println(persons[i]);
                isEmpty = true;
            }
        }
        if (!isEmpty) {
            System.out.println("No patients at the moment");
        }
    }

    public void searchPatientsByDoctorId(String doctorID) {
        boolean isFoundDoctor = false;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient && ((Patient) persons[i]).getSelectedDoctor().equals(doctorID)) {
                System.out.println(persons[i]);
                isFoundDoctor = true;
            }
        }
        if (!isFoundDoctor) {
            System.out.println("No patients found for the given doctor ID: ");
        }
    }


    public boolean isAvailableDateTime(String registerDate) throws ParseException {
        boolean idValidDateTime = true;
        Date registerDateTime = DateUtil.stringToDate(registerDate);

        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient) {

                Date patientRegisteredDate = ((Patient) persons[i]).getRegisterDate();
                long dateInMinutes = (registerDateTime.getTime() - patientRegisteredDate.getTime()) / 60000;

                if (dateInMinutes < 30 || patientRegisteredDate.equals(registerDateTime)) {
                    idValidDateTime = false;
                }
            }
        }
        return idValidDateTime;
    }

    public Doctor getDoctorByID(String doctorID) {
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor && ((Doctor) persons[i]).getDoctorID().equals(doctorID)) {
                return (Doctor) persons[i];
            }
        }
        return null;
    }

    public Patient getPatientCardByID(String patientID) {
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient && ((Patient) persons[i]).getPatientCardID().equals(patientID)) {
                return (Patient) persons[i];
            }
        }
        return null;
    }

    public void searchDoctorByProfession(String doctorProfession) {
        boolean isExamDoctorByProfession = false;

        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor && ((Doctor) persons[i]).getProfession().contains(doctorProfession)) {
                System.out.println(persons[i]);
                isExamDoctorByProfession = true;
            }
        }
        if (!isExamDoctorByProfession) {
            System.out.println("No doctors found with the given profession");
        }
    }

    public void deleteDoctorByID(String doctorID) {
        boolean isTestID = false;
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor && ((Doctor) persons[i]).getDoctorID().equals(doctorID)) {
                for (int j = i; j < size - 1; j++) {
                    persons[j] = persons[j + 1];
                }
                persons[size - 1] = null;
                size--;
                isTestID = true;
                break;
            }
        }
        if (!isTestID) {
            System.out.println("Invalid doctor ID");
        }
    }

    public void changeDoctorByID(String doctorID, String choice, String value) {
        boolean isExamID = false;
        for (int i = 0; i < size; i++) {

            if (persons[i] instanceof Doctor && ((Doctor) persons[i]).getDoctorID().equals(doctorID)) {
                isExamID = true;

                boolean isValidEmail;
                boolean isValidPhoneNumber;

                switch (choice) {
                    case "1":
                        ((Doctor) persons[i]).setDoctorID(value);
                        System.out.println("Doctor ID changed successfully");
                        break;
                    case "2":
                        persons[i].setName(value);
                        System.out.println("Name changed successfully");
                        break;
                    case "3":
                        persons[i].setSurName(value);
                        System.out.println("Surname changed successfully");
                        break;
                    case "4":
                        isValidEmail = examEmail(value);
                        if (isValidEmail) {
                            persons[i].setEmail(value);
                        }
                        break;
                    case "5":
                        isValidPhoneNumber = examPhoneNumber(value);
                        if (isValidPhoneNumber) {
                            persons[i].setPhoneNumber(value);
                        }
                        break;
                    case "6":
                         ((Doctor) persons[i]).setProfession(value);
                        break;
                    default:
                        System.out.println("You have entered an error");
                }
            }
        }
        if (!isExamID) {
            System.out.println("Invalid doctor ID");
        }
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
        if (!phoneNumber.startsWith("+") && phoneNumber.length() != 13 && !phoneNumber.matches("\\+[0-9]+")) {
            System.out.println("Invalid phone number, please try again");
            isValidPhoneNumber = false;
        }
        return isValidPhoneNumber;
    }

    private void extend() {
        Person[] tempArrayPerson = new Person[persons.length + 10];
        System.arraycopy(persons, 0, tempArrayPerson, 0, persons.length);
        persons = tempArrayPerson;
    }
}

