class Solution {
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE){
            return 0;
        }
        
        int result = 0;
        boolean negative = x <  0;
        if(negative){
            x = -x;
        }
        while(x > 0){
            int r = x % 10;
            
            int tmp = result;
            result *= 10;
            if(result /10 != tmp){
                return 0;
            }
            result += r;
            x /= 10;
        }
        return negative ?  -result : result;
    }
}
