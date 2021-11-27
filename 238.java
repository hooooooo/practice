class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] t = new int[nums.length];
        int[] result = new int[nums.length];
        for(int i = nums.length-1; i>=0; i--){
            t[i] = nums[i];
            if(i<nums.length - 1){
                t[i] *= t[i+1];
            }
        }
        
        int p = 1;
        for(int i = 0; i<nums.length; i++){
            if(i > 0){
                p *= nums[i-1];
            }
            result[i] = p;            
            if(i<nums.length - 1){
                result[i] *= t[i+1];
            }
        }
        return result;
        
    }
}
