package classwork.chapter6.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        int a = stack.pop();
        int b = stack.pop();
        int c = stack.pop();
        int e = stack.pop();
        int f = stack.pop();
        int g = stack.pop();
//        int k = stack.pop();
//        int l = stack.pop();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
//        System.out.println(k);
//        System.out.println(l);
    }
}
