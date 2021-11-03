class Solution {
    void swap(int[] nums, int l, int r){
        if(l != r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }
    }
    public int removeElement(int[] nums, int val) {
        int i = nums.length - 1;
        for(int j = 0; j<nums.length && j<= i; ){
            if(nums[j] == val){
                swap(nums, j, i--);
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
