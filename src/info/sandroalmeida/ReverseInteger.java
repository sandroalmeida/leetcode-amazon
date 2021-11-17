package info.sandroalmeida;

public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        while(x != 0){
            int rest = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && rest > 7))
                return 0;
            if(result < Integer.MIN_VALUE/10 ||(result == Integer.MIN_VALUE/10 && rest < -8))
                return 0;
            result = result * 10 + rest;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
