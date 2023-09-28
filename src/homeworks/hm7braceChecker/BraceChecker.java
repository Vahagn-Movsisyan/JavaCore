package homeworks.hm7braceChecker;


public class BraceChecker {
    boolean isCorrectText = true;
    String text;
    int pop;

    BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        StackForBraces stackForBraces = new StackForBraces();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stackForBraces.push(text.charAt(i));
                    break;
                case ')':
                    pop = stackForBraces.pop();
                    if (pop != '(') {
                        System.err.println("Error: opened " + (char) pop + " but closed " + text.charAt(i) + " in line " + (i + 1));
                        isCorrectText = false;
                    }

                    if (stackForBraces.index == -1) {
                        System.err.println("Error: closed ) but not opened");
                        isCorrectText = false;
                    }
                    break;

                case ']':
                    pop = stackForBraces.pop();
                    if (pop != '[') {
                        System.err.println("Error: opened " + (char) pop + " but closed " + text.charAt(i) + " in line " + (i + 1));
                        isCorrectText = false;
                    }

                    if (stackForBraces.index == -1) {
                        System.err.println("Error: closed ] but not opened");
                        isCorrectText = false;
                    }
                    break;


                case '}':
                    pop = stackForBraces.pop();
                    if (pop != '{') {
                        System.err.println("Error: opened " + (char) pop + " but closed " + text.charAt(i) + " in line " + (i + 1));
                        isCorrectText = false;
                    }
                    if (stackForBraces.index == -1) {
                        System.err.println("Error: closed } but not opened");
                        isCorrectText = false;
                    }
                    break;
            }
        }

        while (stackForBraces.index > -1) {
            pop = stackForBraces.pop();
            System.err.println("Error: opened " + (char) pop + " but not closed");
            isCorrectText = false;
        }

        if (isCorrectText) {
            System.out.println("Text is correct");
        }
    }
}
