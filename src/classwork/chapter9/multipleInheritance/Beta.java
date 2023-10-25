package classwork.chapter9.multipleInheritance;

public interface Beta {
    void remove();

    default void reset() {
        System.out.println("Beta");
    }
}
