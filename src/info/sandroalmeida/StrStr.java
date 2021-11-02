package info.sandroalmeida;

public class StrStr {

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        char[] chars = haystack.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == needle.charAt(0)){
                int n = 0;
                for(int j = i; j < chars.length; j++){
                    if(chars[j] == needle.charAt(n)){
                        if(n == needle.length() - 1)
                            return i;
                    } else{
                        break;
                    }
                    n++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "aaaabccd";
        System.out.println(strStr(str,"cd"));
    }
}
