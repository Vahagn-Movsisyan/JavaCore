package homeworks.hm10medicalCenter.storage;

import homeworks.hm10medicalCenter.model.Doctor;
import homeworks.hm10medicalCenter.model.Patient;


public class MedicalCenterStorage {
    Doctor doctor = new Doctor();
    private Patient[] patients = new Patient[10];
    private Doctor[] doctors = new Doctor[10];
    private int patientSize;
    private int doctorSize;

    public void addPatient(Patient patient) {
        if (patientSize == patients.length) {
            extendPatients();
        }
        patients[patientSize++] = patient;
    }

    public void printAllPatients() {
        if (patientSize >= 1) {
            for (int i = 0; i < patientSize; i++) {
                System.out.println(patients[i]);
            }
        } else {
            System.out.println("No patients at the moment");
        }
    }

    public void searchPatientsByDoctorId(String doctorID) {
        boolean isFoundDoctor = false;
        for (int i = 0; i < patientSize; i++) {
           if (patients[i].getSelectedDoctor().equals(doctorID)) {
               System.out.println(patients[i]);
               isFoundDoctor = true;
           }
        }
        if (!isFoundDoctor) {
            System.out.println("No patients found for the given doctor ID: ");
        }
    }

    public Doctor getDoctorByID(String doctorID) {
        for (int i = 0; i < doctorSize; i++) {
            if (doctors[i].getDoctorID().equals(doctorID)) {
                return doctors[i];
            }
        }
        return null;
    }


    public void addDoctor(Doctor doctor) {
        if (doctorSize == doctors.length) {
            extendDoctors();
        }
        doctors[doctorSize++] = doctor;
    }

    public void printAllDoctors() {
        if (doctorSize >= 1) {
            for (int i = 0; i < doctorSize; i++) {
                System.out.println(doctors[i]);
            }
        } else {
            System.out.println("No doctors at the moment");
        }
    }

    public void searchDoctorByProfession(String doctorProfession) {
        boolean isExamDoctorByProfession = false;

        for (int i = 0; i < doctorSize; i++) {
            if (doctors[i].getProfession().contains(doctorProfession)) {
                System.out.println(doctors[i]);
                isExamDoctorByProfession = true;
            }
        }
        if (!isExamDoctorByProfession) {
            System.out.println("No doctors found with the given profession");
        }
    }

    public void deleteDoctorByID(String doctorID) {
        boolean isTestID = false;
        for (int i = 0; i < doctorSize; i++) {
            if (doctors[i].getDoctorID().equals(doctorID)) {
                for (int j = i; j < doctorSize - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }
                doctors[doctorSize - 1] = null;
                doctorSize--;
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
        for (int i = 0; i < doctorSize; i++) {
            if (doctors[i].getDoctorID().equals(doctorID)) {
                isExamID = true;

                boolean isValidEmail;
                boolean isValidPhoneNumber;

                switch (choice) {
                    case "1":
                        doctors[i].setDoctorID(value);
                        System.out.println("Doctor ID changed successfully");
                        break;
                    case "2":
                        doctors[i].setName(value);
                        System.out.println("Name changed successfully");
                        break;
                    case "3":
                        doctors[i].setSurName(value);
                        System.out.println("Surname changed successfully");
                        break;
                    case "4":
                        isValidEmail = examEmail(value);
                        if (isValidEmail) {
                            doctors[i].setEmail(value);
                        }
                        break;
                    case "5":
                        isValidPhoneNumber = examPhoneNumber(value);
                        if (isValidPhoneNumber) {
                            doctors[i].setPhoneNumber(value);
                        }
                        break;
                    case "6":
                        doctors[i].setProfession(value);
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

    private void extendPatients() {
        Patient[] tempArrayPatients = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, tempArrayPatients, 0, patients.length);
        patients = tempArrayPatients;
    }

    private void extendDoctors() {
        Doctor[] tempArrayDoctors = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, tempArrayDoctors, 0, doctors.length);
        doctors = tempArrayDoctors;
    }
}