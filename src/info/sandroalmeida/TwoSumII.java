package info.sandroalmeida;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target)
                right--;
            else if(sum < target)
                left++;
            else
                break;
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,6};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}
