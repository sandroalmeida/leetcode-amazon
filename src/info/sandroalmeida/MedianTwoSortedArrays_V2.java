package info.sandroalmeida;

public class MedianTwoSortedArrays_V2 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if(nums2.length < nums1.length){
            A = nums2;
            B = nums1;
        }
        int total = A.length + B.length;
        int half = total / 2;

        int left = 0, right = A.length - 1;
        while(true){
            int i = (left + right) / 2;
            int j = half - i - 2;

            int ALeft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int ARight = i+1 < A.length ? A[i+1] : Integer.MAX_VALUE;
            int BLeft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int BRight = j+1 < B.length ? B[j+1] : Integer.MAX_VALUE;

            if(ALeft <= BRight && BLeft <= ARight){
                if(total % 2 > 0)
                    return Math.min(ARight, BLeft);
                else
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
            } else if(ALeft > BRight){
                right = i - 1;
            } else{
                left = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4,5,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
