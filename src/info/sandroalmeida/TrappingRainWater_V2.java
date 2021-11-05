package info.sandroalmeida;

public class TrappingRainWater_V2 {

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int currentMax = 0;
        for(int i = 0; i < maxLeft.length; i++){
            maxLeft[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]);
        }

        currentMax = 0;
        for(int i = maxRight.length - 1; i >= 0; i--){
            maxRight[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]);
        }

        int result = 0;
        for(int i = 0; i < height.length; i++){
            int minMaxBorders = Math.min(maxLeft[i], maxRight[i]);
            if(minMaxBorders > height[i])
                result += minMaxBorders - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        // Output: 6
        //
        //               X
        //       X * * * X X * X
        //   X * X X * X X X X X X
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

        int[] height1 = {4,2,3};
        System.out.println(trap(height1));
    }
}
