class Solution {
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        int maxSofar = 0;
        for(int i = 1; i<prices.length; i++){
            currentMax += prices[i] -prices[i-1];
            if(currentMax <0){
                currentMax = 0;
            }
            maxSofar = Math.max(maxSofar, currentMax);            
        }
        return maxSofar;
    }
}
