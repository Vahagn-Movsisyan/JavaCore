package classwork.chapter9.stackExample;

public class IfTest {
    public static void main(String[] args) {
        Stack mystack;
        DynamicStack dynamicStack = new DynamicStack(3);
        FixStack fixStack = new FixStack(3);

        mystack = dynamicStack;
        for (int i = 0; i < 12; i++) {
            mystack.push(i);
        }

        mystack = fixStack;
        for (int i = 0; i < 14; i++) {
            mystack.push(i);
        }
        
        mystack = dynamicStack;
        for (int i = 0; i < 12; i++) {
            System.out.println(mystack.pop());
        }

        mystack = fixStack;
        for (int i = 0; i < 12; i++) {
            System.out.println(mystack.pop());
        }
    }

    private static void useStack(Stack stack, int item) {
        stack.push(item);
        System.out.print(stack.pop() + " ");
    }
}
