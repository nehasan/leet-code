import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> openBraces = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                openBraces.push(ch);
            if (ch == ')') {
                if (openBraces.isEmpty() || openBraces.pop() != '(') return false;
            } else if (ch == '}') {
                if (openBraces.isEmpty() || openBraces.pop() != '{') return false;
            } else if (ch == ']') {
                if (openBraces.isEmpty() || openBraces.pop() != '[') return false;
            }
        }

        return openBraces.isEmpty();
    }

    public void func() {
        String s = new String("()");
        System.out.println(isValid(s));
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        obj.func();
    }
}
