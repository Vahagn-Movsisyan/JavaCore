package classwork.chapter14;

public class GenericExample<T> {
    Object[] objects = new Object[35];
    int size;
    public void add(T object) {
        if (size == objects.length) {
            return;
        }
        objects[size++] = object;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(objects[i]);
        }
    }
}
