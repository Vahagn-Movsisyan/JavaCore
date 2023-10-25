package classwork.chapter10.nestedStatementsTry;

public class NestedTry {
    public static void main(String[] args) {
        int[] numbers = {3, 5};

        try {
            int numbersLen = numbers.length;
            int result = numbersLen / 42;

            System.out.println("len = " + numbersLen);

            try {
                if (numbersLen == 1) numbersLen = numbersLen / (numbersLen - numbersLen);
                if (numbersLen == 2) {
                    numbers[15] = 13;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array error");
            }
        } catch (ArithmeticException e) {
            System.out.println("/ 0");
        }
    }
}
