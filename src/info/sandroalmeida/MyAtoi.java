package info.sandroalmeida;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/
public class MyAtoi {

    public static int myAtoi(String s) {

        s = s.trim();
        if(s == null || s.length() == 0)
            return 0;

        char firstChar = s.charAt(0);
        int start = 0, signal = 1, sum = 0;

        if(firstChar == '-'){
            signal = -1;
            start++;
        } else if(firstChar == '+'){
            start++;
        }

        for(int i = start; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i)))
                return sum * signal;
            int current = Integer.parseInt(s.charAt(i) + "");

            if ((sum > Integer.MAX_VALUE/10) || (sum == Integer.MAX_VALUE/10 && current > 7)){
                if(signal == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            sum = sum * 10 + current;
        }
        return sum * signal;
    }

    public static void main(String[] args) {
        String s = "-2147483650";
        System.out.println(myAtoi(s));
    }
}
