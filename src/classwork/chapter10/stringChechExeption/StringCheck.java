package classwork.chapter10.stringChechExeption;

public class StringCheck {
    public static String stringCheck(String str) throws Exception {
        boolean isCorrectTxt = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                isCorrectTxt = false;
            }
        }
        if (isCorrectTxt) {
            return str.toUpperCase();
        }
        throw new Exception("Error: String is contains number");
    }
}
