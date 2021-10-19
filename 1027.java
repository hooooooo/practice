class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int current = 1; current<nums.length; current++){
            for(int pre = current - 1; pre >= 0; pre--){
                int diff = nums[current] - nums[pre];
                int newKey =  current * 10000000 + 500 + diff;
                if(map.get(newKey) != null){
                    continue;
                }
                int key = pre * 10000000 + 500 + diff;
                map.put(newKey, map.getOrDefault(key, 1) + 1);               
            }
        }
        
        for(Integer i : map.values()){
             max = Math.max(max, i);
        }
        
        return max;
    }
}
