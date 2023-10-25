package classwork.chapter10.stringChechExeption;

public class ExceptionExample {
    public static void main(String[] args) {
        String txt = "I like apple 12";
        String str;
        try {
            str = StringCheck.stringCheck(txt);
            System.out.println(str);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
