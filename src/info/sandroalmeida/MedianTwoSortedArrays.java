package info.sandroalmeida;

public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0, i = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                newArray[i] = nums1[p1];
                p1++;
            } else{
                newArray[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        while(p1 < nums1.length){
            newArray[i] = nums1[p1];
            p1++;
            i++;
        }
        while(p2 < nums2.length){
            newArray[i] = nums2[p2];
            p2++;
            i++;
        }
        int middle = newArray.length / 2;
        if(newArray.length % 2 > 0){
            return newArray[middle];
        } else{
            return (newArray[middle] + newArray[middle-1])/2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4,5,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
