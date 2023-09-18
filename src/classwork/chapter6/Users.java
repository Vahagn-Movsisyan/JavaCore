package classwork.chapter6;

import java.util.List;
import java.util.ArrayList;

public class Users {
    private String name;
    private String email;
    private String password;
    private String conPassword;
    private String phoneNumber;
    private String requirement;
    private String wallet;
    private short age;


    public Users(String name, String email, String password, String conPassword, String phoneNumber, String requirement, String wallet, short age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.conPassword = conPassword;
        this.phoneNumber = phoneNumber;
        this.requirement = requirement;
        this.wallet = wallet;
        this.age = age;
    }

    public Users() {
    }

    public Users(String name, String email, String password, String conPassword, String phoneNumber, short age) {
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            System.out.println("Invalid email");
        } else {
            this.email = email;
        }
    }

    private boolean isValidEmail(String email) {
        if ((email.contains("@") && (email.contains("gmail") || email.contains(".com") || email.contains(".ru")))) {
            return true;
        } else {
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password)) {
            System.out.println("Invalid password");
        } else {
            this.password = password;
        }

    }

    public String getConPassword() {
        return conPassword;
    }


    public void setConPassword(String conPassword) {
        if (!conPassword.equals(password)) {
            System.out.println("Incorrect confirm password");
        } else {
            this.conPassword = conPassword;
        }

    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) System.out.println("The password is short");

        boolean foundUpper = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpper = true;
                break;
            }
        }

        if (!foundUpper) {
            System.out.println("In your password dosen't have a upper world");
            return false;
        } else return true;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Incorrect phone number");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 13) {
            return false;
        } else if (!phoneNumber.startsWith("+")) {
            return false;
        }
        return true;
    }


    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}


class LogIn extends Users {
    public LogIn(String name, String password) {
        super(name, "default_email", password, "default_conPassword", "default_phoneNumber", (short) 0);
    }
}

class Student extends Users {
    public Student(String name, String email, String password, String conPassword, String phoneNumber, String requirement, String wallet, short age) {
        super(name, email, password, conPassword, phoneNumber, requirement, wallet, age);
    }

    public Student(String name, String email, String password, String conPassword, String phoneNumber, short age, String requirement) {
        super(name, email, password, conPassword, phoneNumber, age);
    }
}
class Teatcher extends Users {

    private List<String> teatcherCourses = new ArrayList<>();

    public Teatcher(String name, String email, String password, String conPassword, String phoneNumber, short age) {
        super(name, email, password, conPassword, phoneNumber, age);
    }

    public Teatcher() {

    }
}
