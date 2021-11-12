package info.sandroalmeida;

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            int current = nums[mid];

            if(current == target){
                return mid;
            } else if(current >= nums[left]){
                if(target >= nums[left] && target < current)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else{
                if(target <= nums[right] && target > current)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(search(nums, 0));
    }
}
