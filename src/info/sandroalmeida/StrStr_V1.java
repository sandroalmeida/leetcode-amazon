package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class StrStr_V1 {

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;

        int size = needle.length();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i <= haystack.length() - size; i++){
            String substring = haystack.substring(i, i + size);
            if(!map.containsKey(substring)) {
                map.put(substring, i);
            }
        }

        return map.getOrDefault(needle, -1);
    }

    public static void main(String[] args) {
        String str = "aaaabccd";
        System.out.println(strStr(str,"bccd"));
    }
}
