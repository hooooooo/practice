class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numEmpty = 0;
        int result = 0;
        while(numBottles > 0){
            numBottles--;
            result++;
            numEmpty++;
            if(numEmpty == numExchange){
                numEmpty = 0;
                numBottles++;
            }            
        }
        return result;
    }
}
