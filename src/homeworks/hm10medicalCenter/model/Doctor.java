package homeworks.hm10medicalCenter.model;

public class Doctor extends Person {

    private String doctorID;
    private String profession;

    public Doctor(String name, String surName, String phoneNumber, String email,String profession, String doctorID) {
        super(name, surName, phoneNumber, email);
        this.profession = profession;
        this.doctorID = doctorID;
    }

    public Doctor() {

    }

    public String getDoctorID() {
        return doctorID;
    }


    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", profession='" + profession + '\'' +
                ", name='" + getName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}

