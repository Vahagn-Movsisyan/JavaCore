package homeworks.hm10medicalCenter.storage;

import homeworks.hm10medicalCenter.exeptions.notFoundExceptions.DoublePersonFoundException;
import homeworks.hm10medicalCenter.exeptions.notFoundExceptions.NotFoundPersonException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation.DoubleEmailFoundException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation.IncorrectFormatEmailException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation.DoublePhoneNumberFoundException;
import homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation.InvalidPhoneNumberFormatException;
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
            if (persons[i] instanceof Doctor && size >= 1) {
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
            if (persons[i] instanceof Patient && size >= 1) {
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


    public boolean isAvailableDateTime(String doctorID, String registerDate) throws ParseException {
        boolean idValidDateTime = true;
        Date registerDateTime = DateUtil.stringToDate(registerDate);

        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient && patient.getSelectedDoctor().equals(doctorID)) {

                Date patientRegisteredDate = ((Patient) persons[i]).getRegisterDate();
                long dateInMinutes = (registerDateTime.getTime() - patientRegisteredDate.getTime()) / 60000;

                if (dateInMinutes > -30 && dateInMinutes < 30 || patientRegisteredDate.equals(registerDateTime)) {
                    idValidDateTime = false;
                }
            }
        }
        return idValidDateTime;
    }

    public Doctor getDoctorByID(String doctorID) throws NotFoundPersonException {
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Doctor doctor) {
                if (doctor.getDoctorID().equals(doctorID)) {
                    return (Doctor) persons[i];
                }
            }
        }
        throw new NotFoundPersonException(doctorID + " id dose not found!");
    }

    public Patient getPatientCardByID(String patientID) throws NotFoundPersonException {
        for (int i = 0; i < size; i++) {
            if (persons[i] instanceof Patient patient) {
                if (patient.getPatientCardID().equals(patientID)) {
                    return (Patient) persons[i];
                }
            }
        }
        throw new NotFoundPersonException(patientID + " card id dose not found!");
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

                boolean isValidEmail = false;
                boolean isValidPhoneNumber = false;

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
                        try {
                            isValidEmail = examEmail(value);
                        } catch (DoubleEmailFoundException| IncorrectFormatEmailException e) {
                            System.out.println(e.getMessage());
                        }
                        if (isValidEmail) {
                            persons[i].setEmail(value);
                        }
                        break;
                    case "5":
                        try {
                            isValidPhoneNumber = examPhoneNumber(value);
                        } catch (InvalidPhoneNumberFormatException | DoublePhoneNumberFoundException e) {
                            System.out.println(e.getMessage());
                        }
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


    public boolean examEmail(String email) throws DoubleEmailFoundException, IncorrectFormatEmailException {
        for (int i = 0; i < size; i++) {
            if (persons[i] != null && persons[i].getEmail().equals(email)) {
                throw new DoubleEmailFoundException("Email already exists: " + email);
            }
        }

        if (!email.contains("@") || !email.contains("gmail") || !email.contains(".com")) {
            throw new IncorrectFormatEmailException("Invalid email format");
        }
        return true;
    }

    public boolean examPhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException, DoublePhoneNumberFoundException {
        for (int i = 0; i < size; i++) {
            if (persons[i] != null && persons[i].getPhoneNumber().equals(phoneNumber)) {
                throw new DoublePhoneNumberFoundException(phoneNumber + " phone number already exist");
            }
        }
        if (!phoneNumber.startsWith("+") && phoneNumber.length() != 13 && !phoneNumber.matches("\\+[0-9]+")) {
            throw new InvalidPhoneNumberFormatException(phoneNumber + " Invalid phone number format");
        }
        return true;
    }

    private void extend() {
        Person[] tempArrayPerson = new Person[persons.length + 10];
        System.arraycopy(persons, 0, tempArrayPerson, 0, persons.length);
        persons = tempArrayPerson;
    }
}

