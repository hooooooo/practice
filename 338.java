class Solution {
    int count(int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n & (n -1 );
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 0; i<=n; i++){
            result[i] = count(i);
        }
        return result;
    }
}
