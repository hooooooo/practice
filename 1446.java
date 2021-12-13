class Solution {
    public int maxPower(String s) {
        int maxSoFar = 0;        
        int max = 0;
        
        char lastChar = ' ';
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(lastChar == ch){
                maxSoFar++;
            } else {
                lastChar = ch;
                maxSoFar = 1;
            }
             max = Math.max(max, maxSoFar);
        }
        return max;
        
    }
}
