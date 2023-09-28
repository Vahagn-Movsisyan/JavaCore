package classwork.chapter6.Stack;

public class Stack {
    int[] array;
    int index;

    public Stack(int size){
        array = new int[size];
        index = -1;
    }

    public void push(int item){
        if (index == array.length - 1){
            System.err.println("Sack is full");
        }
        else {
            array[++index] = item;
        }
    }

    public int pop(){
        if (index < 0) {
            System.err.println("Stack is empty");
            return 0;
        }
        else {
            return array[index--];
        }
    }
}
