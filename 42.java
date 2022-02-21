class Solution {
    public int trap(int[] height) {
        int l = 0 ;
        int r = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[r];
        int water = 0;
        while(l < r){
            if(leftMax > rightMax){
                if(height[r-1] > rightMax){
                    rightMax = height[r-1];
                } else {
                    water += rightMax - height[r-1];
                }
                r--;
            } else {
                if(height[l+1] > leftMax){
                    leftMax = height[l+1];
                } else {
                    water += leftMax - height[l+1];
                }
                l++;                
            }
        }
        return water;
        
    }
}
