package classwork.chapter9.sayHelloExampels;

public class RussianPerson implements SayHelloAndGoodBy {

    @Override
    public void sayHello() {
        System.out.println("Privet");
    }

    @Override
    public void sayGoodBy() {
        System.out.println("Poka");
    }
}
