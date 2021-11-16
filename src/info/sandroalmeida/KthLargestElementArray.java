package info.sandroalmeida;

public class KthLargestElementArray {

    public static int findKthLargest(int[] nums, int k) {
        int kIdx = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, kIdx);
    }

    private static int quickSelect(int[] array, int start, int end, int kIdx){
        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            if(array[left] > array[pivot] && array[right] < array[pivot])
                swap(array, left, right);
            if(array[left] <= array[pivot])
                left++;
            if(array[right] >= array[pivot])
                right--;
        }
        swap(array, right, pivot);

        if(right ==  kIdx)
            return array[right];
        else if(right >  kIdx)
            return quickSelect(array, start, right - 1, kIdx);
        else
            return quickSelect(array, right + 1, end, kIdx);
    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

}
