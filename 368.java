class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        int [][] dp = new int[nums.length][2];
        // 0: total count
        // 1: index of previous number
        int max = 0;
        int maxIndex = -1;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            dp[i][0] = 1;
            dp[i][1] = -1;
            for(int j =0; j<i; j++){
                if(nums[i] % nums[j] != 0){
                    continue;
                }
                if(dp[j][0] + 1 > dp[i][0]){
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if(dp[i][0] > max){
                max = dp[i][0];
                maxIndex = i;
            }
        }
        
        while(maxIndex >= 0){
            result.add(nums[maxIndex]);
            maxIndex = dp[maxIndex][1];
        }
        Collections.reverse(result);
        return result;
    }
}
