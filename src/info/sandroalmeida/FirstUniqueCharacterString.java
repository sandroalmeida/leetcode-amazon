package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> mapChar = new HashMap<>();
        for(char c: s.toCharArray())
            mapChar.put(c, mapChar.getOrDefault(c, 0) + 1);
        for(int i = 0; i < s.length(); i++){
            if(mapChar.get(s.charAt(i)) > 1)
                continue;
            else
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
