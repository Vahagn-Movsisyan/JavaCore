package classwork.chapter9.stackExample;

public class FixStack implements Stack {

    private int[] stack;
    private int tos;

    public FixStack(int size) {
        stack = new int[size];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (tos == stack.length - 1) {
            System.out.println("Stack is fully");
        } else {
            stack[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return stack[tos--];
        }
    }
}

