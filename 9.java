class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        
        int t = 1;
        
        long mod = 1000000000;
        while(x / mod == 0){
            mod /= 10;
        }

        
        while(mod > t){
            long right = (x % (t * 10)) / t;
            long left = (x % (mod * 10)) / mod;
            if(left != right){
                return false;
            } 
            t *= 10;
            mod /= 10;
        }
        
        return true;
    }
}
