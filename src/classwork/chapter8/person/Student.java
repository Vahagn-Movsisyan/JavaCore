package classwork.chapter8.person;

public class Student extends Person {
    private int studentID;
    public double score;

    public Student(String name, String surName, String email, String phoneNumber, int studentID, double soccer) {
        super(name, surName, email, phoneNumber);
        this.studentID = studentID;
        this.score = soccer;
    }

    public Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void printHello() {
        System.out.println("Hello I'm Student");
    }
}
