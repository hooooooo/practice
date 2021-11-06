class Solution {
    public int[] singleNumber(int[] nums) {
      int xor = 0;
      for(int  n : nums){
            xor = xor ^ n;
      }
    
      int rightMost = 0;
      int t = xor;
      int bitMask = 1;
      while((t & 1) == 0) {
            t = t >> 1;
            bitMask = bitMask << 1;
      }
        
      int a = 0;
      for(int  n : nums ){
        if((n & bitMask) > 0){
            a =  a^ n;
        }  
      }
      int [] result = new int[2];
      result[0] = a;
      result[1] = xor ^ a;
      return result;
    }
}
