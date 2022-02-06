class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 3){
            return nums.length;
        }
        
        int i2 = nums[0];
        int i1 = nums[1];
        int index = 2;
        for(int i = 2; i<nums.length; i++){
            if(i1 == i2 && i2 == nums[i]){
                continue;
            }
            i2 = i1;
            i1 = nums[i];
            nums[index++] = nums[i];
        }
        return index;        
    }
}
