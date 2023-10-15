package homeworks.hm10medicalCenter.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!Objects.equals(doctorID, doctor.doctorID)) return false;
        return Objects.equals(profession, doctor.profession);
    }

    @Override
    public int hashCode() {
        int result = doctorID != null ? doctorID.hashCode() : 0;
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
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
