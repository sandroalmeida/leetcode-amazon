package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses_V2 {

    static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtracking(new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtracking(StringBuilder current, int open, int close, int max) {
        System.out.println(current);
        if(current.length() == max * 2){
            result.add(current.toString());
            return;
        }
        if(open < max){
            current.append("(");
            backtracking(current, open+1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if(close < open){
            current.append(")");
            backtracking(current, open, close+1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
