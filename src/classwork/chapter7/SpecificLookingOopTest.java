package classwork.chapter7;

public class SpecificLookingOopTest {
    public static void main(String[] args) {
        SpecificLookingOop specificLookingOop = new SpecificLookingOop(1, 2);
        SpecificLookingOop specificLookingOop1 = new SpecificLookingOop(3, 4);

        System.out.println("Testing equalTo metod\n");

        System.out.println(specificLookingOop.equalTo(specificLookingOop));
        System.out.println(specificLookingOop.equalTo(specificLookingOop1));

        System.out.println();

        SpecificLookingOop specificLookingOopReturn1 =  new SpecificLookingOop(2);
        SpecificLookingOop specificLookingOopReturn2;

        System.out.println("Testing returnValue metod\n");

        specificLookingOopReturn2 = specificLookingOopReturn1.incrementByTen();
        System.out.println("specificLookingOopReturn1 returnValue = " + specificLookingOopReturn1.returnValue);
        System.out.println("specificLookingOopReturn2 returnValue = " + specificLookingOopReturn2.returnValue);

        specificLookingOopReturn2 = specificLookingOopReturn2.incrementByTen();
        System.out.println("specificLookingOopReturn2 returnValue now is = " + specificLookingOopReturn2.returnValue);

    }
}
