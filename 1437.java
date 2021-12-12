class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int zl = k;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(i<nums.length && nums[i] == 0){
            i++;
        }
        for( ; i<nums.length; i++){
            if(nums[i] == 0){
                zl ++;
            } else {
                if(zl < k){
                    return false;
                }
                zl = 0;
            }            
        }
        return true;
    }
}
