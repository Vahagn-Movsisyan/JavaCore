package classwork.chapter9.stackExample;

public class DynamicStack implements Stack {
    private int[] stack;
    private int tos;

    public DynamicStack(int size) {
        stack = new int[size];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (tos == stack.length - 1) {
            int[] tmp = new int[stack.length * 2];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;
            stack[++tos] = item;
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
