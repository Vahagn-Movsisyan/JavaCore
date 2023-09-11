package classwork.chapter6;

import java.util.Scanner;

public class GlobalMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                For Create account - '1'
                For logIn - '2'
                """);
        String selectVariant = scanner.nextLine();

        switch (selectVariant) {
            case "1" -> {
                System.out.println("You are student - '1' or teatcher - '2'");
                String selectStudentOrTeatcher = scanner.nextLine();

                switch (selectStudentOrTeatcher) {
                    case "1" -> {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();
                        System.out.print("Confirm your password: ");
                        String conPassword = scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter your requirements: ");
                        String requirement = scanner.nextLine();
                        System.out.print("Enter your age: ");
                        short age = scanner.nextShort();
                        Student signIn = new Student(name, email, password, conPassword, phoneNumber, age, requirement);
                        signIn.setName(name);
                        signIn.setEmail(email);
                        signIn.setPassword(password);
                        signIn.setConPassword(conPassword);
                        signIn.setPhoneNumber(phoneNumber);
                        signIn.setAge(age);
                    }
                    case "2" -> {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();
                        System.out.print("Confirm your password: ");
                        String conPassword = scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter your age: ");
                        short age = scanner.nextShort();
                        Teatcher signIn = new Teatcher(name, email, password, conPassword, phoneNumber, age);
                        signIn.setName(name);
                        signIn.setEmail(email);
                        signIn.setPassword(password);
                        signIn.setConPassword(conPassword);
                        signIn.setPhoneNumber(phoneNumber);
                        signIn.setAge(age);
                    }
                }


            }
            case "2" -> {
                System.out.println("Enter your email: ");
                String lEmail = scanner.nextLine();
                System.out.println("Enter your password: ");
                String lPassword = scanner.nextLine();
                LogIn logIn = new LogIn(lEmail, lPassword);
                logIn.setEmail(lEmail);
                logIn.setPassword(lPassword);
            }
        }
    }
}
