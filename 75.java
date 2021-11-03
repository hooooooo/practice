class Solution {
    void swap(int[] nums, int l, int r){
        if(l == r){
            return;
        }
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
    public void sortColors(int[] nums) {
        int whiteIndex = 0;
        int redIndex = nums.length - 1;
        for(int i = 0; i<nums.length &&  i<= redIndex; ){
            if(nums[i] == 0){
                swap(nums, i++, whiteIndex++);
            } else if(nums[i] == 2) {
                swap(nums, redIndex--, i);
            } else {
                i++;
            }
        }
    }
}
