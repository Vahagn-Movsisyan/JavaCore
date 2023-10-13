package classwork.chapter8.person;

public class Teatcher extends Person {
    private int teacherID;
    private double teatcherSalary;

    public Teatcher(String name, String surName, String email, String phoneNumber, int teacherID) {
        super(name, surName, email, phoneNumber);
        this.teacherID = teacherID;
    }

    public Teatcher() {
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public double getTeatcherSalary() {
        return teatcherSalary;
    }

    public void setTeatcherSalary(double teatcherSalary) {
        this.teatcherSalary = teatcherSalary;
    }

    @Override
    public void printHello() {
        System.out.println("Hello i'm teatcher");
    }
}
