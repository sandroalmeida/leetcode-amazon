package info.sandroalmeida;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private static boolean helper(String str, Set<String> wordDict, int start){
        if(start == str.length())
            return true;
        for(int end = start + 1; end <= str.length(); end++){
            if(wordDict.contains(str.substring(start,end)) && helper(str, wordDict, end))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Example 1:
        //Input: s = "leetcode", wordDict = ["leet","code"]
        //Output: true
        List<String> list1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", list1));
    }
}
