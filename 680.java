class Solution {
    
    boolean isValid(char[] arr, int l, int r, boolean deleted){
        while(l<r){
            if(arr[l] == arr[r]){
                l++;
                r--;
                continue;
            }
            if(deleted){
                return false;
            }
            return isValid(arr, l+1, r, true) || isValid(arr, l, r-1, true);    
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        return isValid(arr, l, r, false);
    }
}
