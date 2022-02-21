class Solution {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            int count = map.getOrDefault(i, 0) + 1;
            if(count > half){
                return i;
            }
            map.put(i, count);            
        }
        return 0;        
    }
}
