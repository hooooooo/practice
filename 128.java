class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int longest = 0;
        while(longest < set.size()){
            int max = 1;
            int n = set.iterator().next();
            set.remove(n);
            
            int left = n-1;
            int right = n+1;
            while(set.contains(left)){
                max ++;
                set.remove(left);
                left --;
            }
            while(set.contains(right)){
                max++;
                set.remove(right);
                right++;
            }
            longest = Math.max(longest, max);            
        }        
        return longest;
    }
}
