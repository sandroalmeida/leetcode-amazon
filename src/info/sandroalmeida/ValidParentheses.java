package info.sandroalmeida;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else{
                if(stack.isEmpty())
                    return false;
                char current = stack.pop();
                if((c == ')' && current != '(') || (c == ']' && current != '[') ||(c == '}' && current != '{'))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}}";
        System.out.println(isValid(s));
    }

}
