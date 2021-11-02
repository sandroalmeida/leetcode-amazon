package info.sandroalmeida;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        int currentProd = 1;
        for(int i = 1; i < nums.length; i++){
            currentProd *= nums[i - 1];
            leftProduct[i] = currentProd;
        }

        currentProd = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            currentProd *= nums[i + 1];
            rightProduct[i] = currentProd;
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0)
                result[i] = rightProduct[i];
            else if(i == nums.length - 1)
                result[i] = leftProduct[i];
            else
                result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] res1 = productExceptSelf(nums1);
        for(int n: res1)
            System.out.print(n + " ");

        System.out.println("");

        int[] nums2 = {-1,1,0,-3,3};
        int[] res2 = productExceptSelf(nums2);
        for(int n: res2)
            System.out.print(n + " ");
    }

}
