class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        int diff = 'A' - 'a';
        for(int i = 0; i<arr.length; i++){
            if((arr[i] >= 'a' && arr[i] <= 'z') || 
               (arr[i] >= '0' && arr[i] <= '9') ){
                arr[index++] = arr[i];
                continue;
            }
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[index++] = (char)(arr[i] - diff);
            }
        }
        int half = index / 2;
        for(int i = 0; i<half; i++){
            if(arr[i] != arr[index - i - 1]){
                return false;
            }
        }
        return true;        
    }
}
