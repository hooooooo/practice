class Solution {
    
    int help(char[] arr, int index){
        
        int  len = 1;
        for(int i = 0; i<arr.length && index - i - 1>=0 && index + i + 1 < arr.length; i++){
            if(arr[ index - i - 1] != arr[index + i + 1]){
                break;
            } 
            len += 2;
        }
         
        int max = len;
        len = 0;
        for(int i = 0; i<arr.length && index - i - 1>=0 && index + i < arr.length; i++){
             if(arr[ index - i - 1] != arr[index + i]){
                break;
            } 
            len += 2;
        }
        return Math.max(len, max);
    }
    
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        int index = 0;
        for(int i = arr.length / 2; i<arr.length; i++){
            int len = help(arr, i);
            int len2 = help(arr, arr.length - 1 - i ); 
            int maxLen = len >len2 ? len: len2;
            int index2 = len > len2 ? i : arr.length - 1 - i;
            if(maxLen > max){
                max = maxLen;
                index = index2; 
            }            
        }
        
        int i = index - max / 2;
        return new String(arr, i, max);        
    }
}
