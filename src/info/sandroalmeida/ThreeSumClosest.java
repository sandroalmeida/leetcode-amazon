package info.sandroalmeida;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest = 0;

        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;

            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDiff = target - currentSum;
                if(Math.abs(currentDiff) < diff){
                    closest = currentSum;
                    diff = Math.abs(currentDiff);
                }
                if(currentSum > target){
                    right--;
                } else if(currentSum < target){
                    left++;
                } else{
                    return target;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] array = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(array, -1));
    }
}
