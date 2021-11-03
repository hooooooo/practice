class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length; i++){
            if(i ==0 || nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
