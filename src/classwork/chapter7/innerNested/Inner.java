package classwork.chapter7.innerNested;

public class Inner {
    final String FIRST_CARD_NUMBER = "3451 2341 0112 3962";
    final String SECOND_CARD_NUMBER = "4561 7871 6712 8811";

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.testInner();
    }

    void testInner() {
        PrintCardNumbers printCardNumbers = new PrintCardNumbers();
        printCardNumbers.display();
    }
}

     class PrintCardNumbers {
     Inner inner = new Inner();
        void display(){
            System.out.println("The card number 1: " + inner.FIRST_CARD_NUMBER);
            System.out.println("The card number 2: " + inner.SECOND_CARD_NUMBER);
        }
}

