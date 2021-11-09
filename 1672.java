class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        if(accounts == null || accounts.length == 0 || accounts[0].length == 0){
            return max;
        }
        for(int row = 0; row < accounts.length; row++){
            int wealth = 0;
            for(int column =0; column < accounts[row].length; column++){
                wealth += accounts[row][column];
            }    
            max = Math.max(max, wealth);
        }
        return max;
    }
}
