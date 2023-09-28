package homeworks.hm7braceChecker;

public class StackForBraces {
    int[] stackArray;
    int index;

    StackForBraces(){
        stackArray = new int[10];
        index = -1;
    }

    public void push(int item){
        if (index == stackArray.length){
            extend();
        }
        stackArray[++index] = item;
    }

    private void extend(){
        int[] newStackArray = new int[stackArray.length + 10];
        System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
        stackArray = newStackArray;
    }


   public int pop(){
        if (index < 0) {
            System.err.println("Stack is empty");
            return 0;
        }
        else {
            return stackArray[index--];
        }
    }
}
