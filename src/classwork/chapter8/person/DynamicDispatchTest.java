package classwork.chapter8.person;

public class DynamicDispatchTest {
    public static void main(String[] args) {
        Teatcher teatcher = new Teatcher();
        Student student = new Student();

        sendEmail(teatcher);
        sendEmail(student);

    }

    public static void sendEmail(Person person) {
        System.out.println("Email is send " + person.getEmail());
        person.printHello();
    }
}
