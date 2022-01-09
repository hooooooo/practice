class Solution {
    
    char inc(char c){
        if(c =='z'){
            return 'a';
        }
        return (char)(c + 1);
    }
    char dec(char c){
        if(c == 'a'){
            return 'z';
        }
        return (char)(c - 1);
    }
    
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != '?'){
                continue;   
            }
            char last = 'a';
            if(i > 0){
                last = arr[i-1];
            }
            char ch = inc(last);
            if(i != arr.length -1 && arr[i+1] == ch){
                ch = dec(last);                
            }            
            arr[i] = ch;            
        }
        return new String(arr);        
    }
}
