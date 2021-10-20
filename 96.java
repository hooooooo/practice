class Solution {
    public int numTrees(int n) {
        int[]dp = new int[n+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if(n < 3) return dp[n];
        int i = 3;
        while(i <= n){
            int count = 0;
            for(int root = 0; root < i; root++){
                int left = dp[root];
                int right = dp[i - root - 1];
                count += left * right;
            }
            dp[i] = count;
            i++;
        }
        return dp[n];
    }
}
