package info.sandroalmeida;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }
}
