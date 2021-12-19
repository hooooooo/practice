class Solution {
    String helper(String s){
        StringBuilder sb = new StringBuilder();        
        int digitStart = -1;
        int leftBraceIndex = -1;
        int braceCount = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '['){
                if(leftBraceIndex == -1){
                    leftBraceIndex = i;
                }
                braceCount ++;
            } else if(ch == ']') {
                braceCount --;
                if(braceCount == 0){
                    int num = Integer.parseInt(s.substring(digitStart, leftBraceIndex));
                    String t = helper(s.substring(leftBraceIndex + 1, i));
                    // sb.append(); string.repeat
                    for(int k = 0; k<num; k++){
                        sb.append(t);
                    }
                    // reset
                    digitStart = -1;
                    leftBraceIndex = -1;
                    braceCount = 0;    
                }            
            } else if(ch >= '0' && ch <= '9'){
                if(digitStart == -1){
                    digitStart = i;
                }                
            } else {
                if(digitStart == -1){
                    sb.append(ch);
                }
            }
        
        }
        return sb.toString();
        
    }
    public String decodeString(String s) {
        return  helper(s);
    }
}
