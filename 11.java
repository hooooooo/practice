class Solution {
    
    
    int computeArea(int[] height, int l, int r){
        int area = 0;
        int level = Math.min(height[l], height[r]);       
        return (r - l) * level;
    }

    
    public int maxArea(int[] height) {
        int maxLevel = 0;
        
        for(int  h : height){
            maxLevel = Math.max(maxLevel, h);
        }
        
        
        int maxWater = 0;
        int l = 0;
        int r = 0;
        for(int x = maxLevel; x >= 1; x--){
            l = -1;
            r = -1;
            for(int i = 0; i<height.length - 1; i++){
                if(l == -1 && height[i] >= x){
                    l = i;
                    break;
                }                          
            }
            for(int i = height.length - 1; i > 0; i--){
                if(r == -1 && height[i] >= x){
                    r = i;
                    break;
                }                          
            }            
            if(l == r || l == -1 || r == -1){
                continue;
            }
            int area = computeArea(height, l, r);
            maxWater = Math.max(area, maxWater);
        }
        
        return maxWater;        
    }
}
