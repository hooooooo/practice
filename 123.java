class Solution {
    public int maxProfit(int[] prices) {
        int[] tradeEnd = new int[prices.length];
        int[] tradeFrom = new int[prices.length];
        
        
        int min = prices[0];
        int max = prices[prices.length-1];
        
        int currentMax = 0;
        int currentMin = 0;
        int ret = 0;
        
        for(int i=1; i<prices.length; i++){ 
            tradeEnd[i] = currentMax = Math.max(currentMax, prices[i] - min);            
            min = Math.min(min, prices[i]);
        }
        
        currentMax = 0;
        for(int i=prices.length - 2; i>= 0; i--){
            tradeFrom[i] = currentMax = Math.max(currentMax, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        for(int i = 0; i<prices.length; i++){
            ret = Math.max(tradeEnd[i], ret);
            if(i < prices.length -1){
                ret = Math.max(tradeEnd[i] + tradeFrom[i+1], ret);
            }            
        }
        return ret;
    }
}
