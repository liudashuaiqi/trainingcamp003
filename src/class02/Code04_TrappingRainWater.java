package class02;
//leetcode测试 正确
public class Code04_TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int leftPointer = 1;
        int rightPointer = height.length-2;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int ans = 0;
        while(leftPointer <= rightPointer){
            if(leftMax < rightMax){
                ans += Math.max(leftMax-height[leftPointer],0);
                leftMax = Math.max(leftMax,height[leftPointer]);
                leftPointer++;
            }else{
                ans += Math.max(rightMax-height[rightPointer],0);
                rightMax = Math.max(rightMax,height[rightPointer]);
                rightPointer--;
            }
        }

        return ans;
    }
}
