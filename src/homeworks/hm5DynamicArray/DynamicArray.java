package homeworks.hm5DynamicArray;

public class DynamicArray {
    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] arrayOne = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if (arrayOne.length == size) {
            extend();
        }
        arrayOne[size] = value;
        ++size;
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend() {
        int[] arrayTwo = new int[arrayOne.length + 10];
        for (int i = 0; i < size; i++) {
            arrayTwo[i] = arrayOne[i];
        }
        arrayOne = arrayTwo;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index) {
        if (index <= size && index >= 0) {
            return arrayOne[index];

        }
        return -1;
    }

    public void deleteByIndex(int index){
       if (index <= size){
           for (int i = index; i < size - 1; i++) {
               arrayOne[i] = arrayOne[i + 1];
           }
           for (int i = 0; i < size - 1; i++) {
               System.out.print(arrayOne[i] + " ");
           }
       }
       else System.out.println("Index isn't in array");
    }

    public void set(int index, int value){
        if (index <= arrayOne.length) {
            arrayOne[index] = value;
            print();
        } else {
            System.out.println(index + " this index isn't in array");
        }
    }

    public void add(int index, int value){
        if (index <= arrayOne.length){
            for (int i = index; i < arrayOne.length - 1; i++) {
                arrayOne[index] = value;
                arrayOne[i] = arrayOne[i + 1];
            }
            printAllElements();
        }
        else {
            System.out.println(index + " isn't in array");
        }
    }

    public boolean exists(int value){
        for (int i = 0; i < size; i++) {
            if (arrayOne[i] == value) return true;
        }
        return false;
    }

    public int getIndexByValue(int value) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (value == arrayOne[i]){
                count++;
            }
        }
        if (count > 1){
            return value;
        }
       return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();
    }

    public void printAllElements(){
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();
    }
}
