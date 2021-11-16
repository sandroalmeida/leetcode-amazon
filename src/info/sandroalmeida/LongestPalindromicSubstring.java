package info.sandroalmeida;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int[] currentStr = {0, 1};

        for(int i = 1; i < s.length(); i++) {
            int[] odd = getLongestPalindromic(s, i - 1, i + 1);
            int[] even = getLongestPalindromic(s, i, i -1);
            int oddSize = odd[1] - odd[0];
            int evenSize = even[1] - even[0];
            int currentSize = currentStr[1] - currentStr[0];
            if(oddSize > currentSize || evenSize > currentSize){
                if(oddSize > evenSize)
                    currentStr = odd;
                else
                    currentStr = even;
            }
        }
        return s.substring(currentStr[0], currentStr[1]);
    }

    public static int[] getLongestPalindromic(String str, int left, int right){
        while(left >= 0 && right < str.length()){
            if(str.charAt(left) != str.charAt(right))
                break;
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

    public static void main(String[] args) {
        String str = "jksihdksdssdf";
        System.out.println(longestPalindrome(str));
    }
}
