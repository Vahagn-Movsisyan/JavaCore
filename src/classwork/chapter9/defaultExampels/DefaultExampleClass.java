package classwork.chapter9.defaultExampels;

public class DefaultExampleClass implements DefaultExample {
    @Override
    public int getNumber() {
        return 10;
    }

    @Override
    public String getString() {
        return "hello";
    }
}
