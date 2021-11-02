package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2965/
public class RomanToInteger {
    public static int romanToInt(String s) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < romans.length; i++)
            map.put(romans[i], values[i]);

        int result = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){
            String current = chars[i]+"";
            if(i < chars.length - 1){
                String next = chars[i+1]+"";
                if(map.get(current) < map.get(next)){
                    result += map.get(current + next);
                    i++;
                } else{
                    result += map.get(current);
                }
            } else{
                result += map.get(current);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String n1 = "MXL";
        System.out.println(romanToInt(n1));
    }
}
