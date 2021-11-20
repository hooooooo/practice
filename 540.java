class Solution {
    
    private int helper(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        
        int mid = left + (right - left) / 2; 
        if(nums[mid - 1] == nums[mid]){
            if((mid + 1) % 2 == 0){
                return helper(nums, mid + 1,  right);
            } else {
                return helper(nums, left, mid - 2);
            }
        } 
        
        if(nums[mid + 1] == nums[mid]) {
            if((right - mid + 1) % 2 == 1){
                return helper(nums, mid + 2,  right);
            } else {
                return helper(nums, left, mid - 1);
            }
        }
        
        return nums[mid];
    }
    
    public int singleNonDuplicate(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
