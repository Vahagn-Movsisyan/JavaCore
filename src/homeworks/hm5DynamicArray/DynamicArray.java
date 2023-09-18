package homeworks.hm5DynamicArray;

public class DynamicArray {
    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] arrayOne = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if (arrayOne.length == size){
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
            if (index <= size && index >= 0){
                return arrayOne[index];

            }
        return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int printElements : arrayOne) {
            System.out.print(printElements + " ");
        }
        System.out.println();
    }
}
