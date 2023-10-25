package classwork.chapter9.sayHelloExampels;

public class EnglishPerson implements SayHelloAndGoodBy, SayHowAreYou {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayGoodBy() {
        System.out.println("Good by");
    }

    @Override
    public void sayHowAreYou() {
        System.out.println("How are you");
    }
}
