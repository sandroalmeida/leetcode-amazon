package info.sandroalmeida;

import java.util.*;

public class LetterCombinationsPhoneNumber {

    static List<String> result;
    static Map<Character, List<String>> mapDigit;

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.equals("")) return result;

        mapDigit = new HashMap<>();
        mapDigit.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        mapDigit.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        mapDigit.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        mapDigit.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        mapDigit.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        mapDigit.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        mapDigit.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        mapDigit.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        helper(digits, 0, "");
        return result;
    }

    private static void helper(String digits, int position, String subString){
        List<String> letters = mapDigit.get(digits.charAt(position));

        for (String letter : letters) {
            String combination = subString + letter;
            if (position == digits.length() - 1) {
                result.add(combination);
            } else {
                helper(digits, position + 1, combination);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("237"));
    }
}
