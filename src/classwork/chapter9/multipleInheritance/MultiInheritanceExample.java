package classwork.chapter9.multipleInheritance;

public class MultiInheritanceExample implements Alpha, Beta {
    @Override
    public void remove() {
        System.out.println("Remove");
    }

    @Override
    public void reset() {
        Beta.super.reset();
        Alpha.super.reset();
    }
}
