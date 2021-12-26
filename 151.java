class Solution {
    
    void reverse(char[] arr, int start, int end){
        int size = (end - start + 1);
        int half = size / 2;
        
        for(int i = 0; i< half; i++){
            char c = arr[start + i];
            arr[start + i] = arr[start + size - i - 1];
            arr[start + size - i - 1] = c;            
        }
    }
    
    int prepare(char[] arr){
        // first reverse the whole string
        reverse(arr, 0, arr.length - 1);
        
        // remove unnecessary zeros
        char last = ' ';
        int index = -1;
        for(int i = 0; i<arr.length; i++){
            if(last ==' ' && arr[i] == ' '){
                continue;
            }
            arr[++index] = arr[i];
            last = arr[i];
        }
        
        if(index != -1 && arr[index] ==' '){
            index --;
        }
        return index + 1;        
    }
    
     
    
    void reverseSubString(char[] arr, int size){
        int start = 0;
        for(int i = 0; i<size; i++){
            if(arr[i] == ' '){
                reverse(arr, start, i-1);
                start = i + 1;
            } else if(i == size - 1) {
                reverse(arr, start, i);
            }            
        }    
    }
    
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int size = prepare(arr);
        reverseSubString(arr, size);
        return new String(arr, 0, size);
    }
}
