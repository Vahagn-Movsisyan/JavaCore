package classwork.chapter9.multipleInheritance;

public interface Alpha {
    void remove();

    default void reset() {
        System.out.println("Alpha");
    }
}
