package info.sandroalmeida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            int diff = 0 - nums[i];
            if(i != 0 && nums[i - 1] == nums[i]){
                continue;
            }
            while(left < right){
                if(nums[left] + nums[right] > diff){
                    right--;
                } else if(nums[left] + nums[right] < diff){
                    left++;
                } else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while(left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-2,0,0,2,2};
        System.out.println(threeSum(array));
    }
}
