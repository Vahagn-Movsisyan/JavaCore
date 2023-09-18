import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String str = "{bo(lo){la}]";

        for (int i = 0; i < str.length(); i++) {
           char examTxt = str.charAt(i);

           switch (examTxt){
               case '{':
               case '(':
               case '[':

           }
        }
    }
}
