package info.sandroalmeida;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

    public static String auxiliar(int digit, int factor){
        StringBuilder result = new StringBuilder();
        if(factor == 1){
            if(digit < 4){
                result.append("I".repeat(Math.max(0, digit)));
            } else if(digit == 4){
                result.append("IV");
            } else if(digit == 5){
                result.append("V");
            } else if(digit < 9){
                result.append("V");
                result.append("I".repeat(digit - 5));
            } else if(digit == 9)
                result.append("IX");
        }


        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(8));
        System.out.println(intToRoman(14));
        System.out.println(intToRoman(44));
        System.out.println(intToRoman(566));
        System.out.println(intToRoman(997));
        System.out.println(intToRoman(1800));
        System.out.println(intToRoman(3999));
    }
}
