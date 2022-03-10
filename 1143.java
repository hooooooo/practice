class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int max = 0;
        int t = 0;
        for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j<arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    t = 1;
                    if(i> 0 && j > 0) {
                        t += dp[i-1][j-1];
                    }
                } else {
                    t = 0;
                     if(i> 0) {
                         t = dp[i-1][j];
                    }
                     if(j > 0){
                         if(dp[i][j-1] > t){
                             t = dp[i][j-1];
                         }
                    }
                }
                
                max = Math.max(t, max);
                dp[i][j] = t;
            }
        }
        return max;        
    }
}
