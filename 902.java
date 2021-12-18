class Solution {
    int helper(int []d, int[] dp, int[] value, int i){
        int count = 0; 
        int j = 0;
        while(j < d.length && d[j] < value[i]){
            j++;
            if(i < value.length - 1){
                count += (int)Math.pow(d.length, dp.length - i - 1); // dp[i + 1];
            } else if(i == value.length - 1){
                count++;
            }   
         }
        
         // all santisfied
         if(j == d.length){
             return count;
         }
        
         // none santified
         if( j == 0 && d[j] > value[i]){
             return count;
         }
         
         if(i == value.length - 1){
             return d[j] > value[i] ? count : count + 1;
         }
        
         if(d[j] == value[i]){
            return count + helper(d, dp, value, i+1);        
         }
        return count;
    }
    
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] d = new int[digits.length];
        for(int i = 0; i <digits.length; i++){
            d[i] = (int)(digits[i].charAt(0) - '0');
        }
        
        String tmp = Integer.toString(n);
        int[] value = new int[tmp.length()];
        for(int i = 0; i<value.length; i++){
            value[i] = (int)(tmp.charAt(i) - '0');
        }
        
        int[]dp = new int[value.length];
        for(int i = dp.length - 1; i >= 0; i--){
            dp[i] = (int)Math.pow(d.length, dp.length - i);
            if(i < dp.length  - 1){
                dp[i] += dp[i+1];
            }
        }
        
        int count = 0;
        if(value.length > 1){ // without fill
            count = dp[1];
        }
        
        count += helper(d, dp, value, 0);
        return count;
       
    }
}
