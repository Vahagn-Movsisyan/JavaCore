package classwork.chapter9.sayHelloExampels;

import java.util.Scanner;

public class personsTs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRun = true;

        while (isRun) {
            System.out.println("1. English person");
            System.out.println("2. Russian person");
            System.out.println("3. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    EnglishPerson englishPerson = new EnglishPerson();
                    Say(englishPerson);
                    break;
                case "2":
                    RussianPerson russianPerson = new RussianPerson();
                    Say(russianPerson);
                    break;
                case "0":
                    isRun = false;
                    break;
            }
        }

    }

    static void Say(SayHelloAndGoodBy sayHelloAndGoodBy) {
        sayHelloAndGoodBy.sayHello();
        sayHelloAndGoodBy.sayGoodBy();

        if (sayHelloAndGoodBy instanceof SayHowAreYou) {
            SayHowAreYou sayHowAreYou = (SayHowAreYou) sayHelloAndGoodBy;
            sayHowAreYou.sayHowAreYou();
        }
    }
}
