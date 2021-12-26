class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if(n % 2 == 1){       
            result[n/2] = 0;
        }
        int seed = 1;
        for(int i = 0; i<n/2; i++){
            result[i] = seed;
            result[n - i - 1] = -seed;
            seed ++;
        }        
        return result;
    }
}
