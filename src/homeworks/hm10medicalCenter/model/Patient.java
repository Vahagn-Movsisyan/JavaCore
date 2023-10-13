package homeworks.hm10medicalCenter.model;

import java.util.Date;

public class Patient extends Person {
    private String patientCardID;
    private String selectedDoctor;
    private  String registerDate;


    public Patient(String patientCardID, String name, String surName, String phoneNumber, String email, String selectedDoctor, String registerDate) {
        super(name, surName, phoneNumber, email);
        this.patientCardID = patientCardID;
        this.selectedDoctor = selectedDoctor;
        this.registerDate = registerDate;
    }

   public Patient(){

   }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getPatientCardID() {
        return patientCardID;
    }

    public void setPatientCardID(String patientCardID) {
        this.patientCardID = patientCardID;
    }

    public String getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(String selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientCardID='" + patientCardID + '\'' +
                ", selectedDoctor=" + selectedDoctor +
                ", date='" + registerDate + '\'' +
                ", name='" + getName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
