public class BracketChecker {
    private String input ;

    public BracketChecker(String in) {
        input = in;
    }

    public boolean check() {
        LinkStack theStack = new LinkStack();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{' :
                case '[' :
                case '(' :
                    theStack.push(ch);
                    break;
                case '}' :
                case ']' :
                case ')' :
                    if (!theStack.isEmpty()) {
                        char popped = theStack.pop();
                        if ((popped != '{' && ch == '}') || (popped != '[' && ch == ']') || (popped != '(' && ch == ')'))
                            return false;
                    } 
                    else 
                        return false;
                    break ;
            }
        }
        if (!theStack.isEmpty()) 
            return false;
        return true;
    }
}
