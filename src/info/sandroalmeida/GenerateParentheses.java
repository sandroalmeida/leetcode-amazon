package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n, 1, "");
        return result;
    }

    private static void helper(int n, int current, String subStr) {
        if(current == n * 2){
            subStr = subStr + ")";
            if(isValid(subStr))
                result.add(subStr);
        } else{
            helper(n, current+1, subStr + "(");
            if(current != 0)
                helper(n, current+1, subStr + ")");
        }
    }

    private static boolean isValid(String combination){
        Stack<Character> stack = new Stack<>();
        char[] chars = combination.toCharArray();
        if(chars[0] == ')') return false;
        else stack.push(chars[0]);

        for(int i = 1; i < chars.length; i++){
            char current = chars[i];
            if(current == '(')
                stack.push(current);
            else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
