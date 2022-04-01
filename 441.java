class Solution {
    public int arrangeCoins(int i) {
        long n = i;
        long x = (long)(Math.floor(Math.sqrt(n * 2)));
        while((1+x) * x  > n * 2){
          x--;
        }        
        return (int)x;    
    }
}
