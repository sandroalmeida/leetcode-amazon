package info.sandroalmeida;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean helper(String str, Set<String> wordDict, int start, Boolean[] memo){
        if(start == str.length())
            return true;

        if(memo[start] != null)
            return memo[start];

        for(int end = start + 1; end <= str.length(); end++){
            if(wordDict.contains(str.substring(start,end)) && helper(str, wordDict, end, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        //Example 1:
        //Input: s = "leetcode", wordDict = ["leet","code"]
        //Output: true
        List<String> list1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", list1));
    }
}
