class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for(String str: strs){
            len = Math.min(len, str.length());
        }
        int max = len;
        StringBuilder sb = new StringBuilder();
        while(len > 0){
            boolean match = true;
            char ch = ' ';
            for(String str: strs){
                char c = str.charAt(max - len);
                if(ch == ' '){
                    ch = c;
                    continue;
                }
                if(c != ch){
                    match = false;
                    break;
                }
            }
            if(!match){
                break;
            }
            sb.append(ch);
            len--;
        }
        return sb.toString();
    }
}
