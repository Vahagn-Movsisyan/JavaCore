package classwork.chapter4;

public class TernaryOperation {
    public static void main(String[] args) {

        //[первая операция] ? [вторая операция] : [третий операция]
        //  true , false  true - работает вторая  false - работает третий

        int a = 4;
        String result = (a % 2 == 0) ? "even" : "odd";
        System.out.println(result);



    }
}
