package info.sandroalmeida;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int rangeSum = 0, n = 0;
        while(n <= nums.length){
            rangeSum += n;
            n++;
        }
        int arraySum = 0;
        for(int i: nums){
            arraySum += i;
        }
        return rangeSum - arraySum;
    }

    public static void main(String[] args) {
        int[] array = {0,1,3};
        System.out.println(missingNumber(array));
    }
}
