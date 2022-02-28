class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        int start = -1;
        for(int i = 0; i<nums.length; i++){
            if(start == -1){
                start = i;
                continue;
            }
            if(nums[i] != nums[i-1] + 1){
                if(start == i - 1){
                    result.add(Integer.toString(nums[start]));
                } else {
                    result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[i-1]));
                }
                start = i;
            }
        }
        
        if(start == nums.length - 1){
             result.add(Integer.toString(nums[start]));
        } else {
            result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[nums.length - 1]));
        }
        
        return result;
    }
}
