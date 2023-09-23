package classwork.chapter7;

public class SpecificLookingOop {

    int a, b;
    int returnValue;

    SpecificLookingOop(int i, int j) {
        a = i;
        b = j;
    }

    SpecificLookingOop(int returnValue){
        this.returnValue = returnValue;
    }

    SpecificLookingOop incrementByTen(){
        SpecificLookingOop specificLookingOopTemp = new SpecificLookingOop(returnValue + 10);
        return specificLookingOopTemp;
    }

    boolean equalTo(SpecificLookingOop ob) {
        if (ob.a == a && ob.b == b) {
            return true;
        } else return false;
    }
}
