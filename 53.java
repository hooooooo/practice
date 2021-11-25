class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            maxSoFar += i;
            max = Math.max(max, maxSoFar);
            if(maxSoFar < 0){
                maxSoFar = 0;
            }
        }
        return max;
    }
}
