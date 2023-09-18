package classwork.chapter6.Stack;

public class Stack {
    int[] array = new int[10];
    int index;

    Stack(){
        index = -1;
    }

    void push(int item){
        if (index == 9){
            System.err.println("Sack is full");
        }
        else {
            array[++index] = item;
        }
    }

    int pop(){
        if (index < 0) {
            System.err.println("Stack is empty");
            return 0;
        }
        else {
            return array[index--];
        }
    }
}
