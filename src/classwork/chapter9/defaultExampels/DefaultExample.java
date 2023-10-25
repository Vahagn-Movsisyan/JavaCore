package classwork.chapter9.defaultExampels;

public interface DefaultExample {
    int getNumber();

    default String getString() {
        return "It's default metod";
    }
}
