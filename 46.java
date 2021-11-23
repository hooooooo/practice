class Solution {
    
    
    void helper(int[] nums, boolean[] used, int index, List<List<Integer>> result, int[]tmp) {
        if(index == nums.length){
            List<Integer> l = new ArrayList<>(nums.length);
            for(int i : tmp){
                l.add(i);
            }
            result.add(l);
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            tmp[index] = nums[i];
            helper(nums, used, index +1, result, tmp);
            used[i] = false;
        }        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        
        int[]tmp = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        helper(nums, used, 0, result, tmp);
        return result;
    }
}
