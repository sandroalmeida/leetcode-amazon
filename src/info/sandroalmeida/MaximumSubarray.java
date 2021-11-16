package info.sandroalmeida;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        int sum = 0;
        for(int i: nums)
            sum += i;

        int partialSum = sum;
        while(left <= right){

            if(nums[left] < nums[right]){
                partialSum -= nums[left];
                left++;
            } else{
                partialSum -= nums[right];
                right--;
            }
            sum = Math.max(sum, partialSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
