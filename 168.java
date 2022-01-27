class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            if(columnNumber > 26){
                int quotient = columnNumber / 26;
                int remainder =  columnNumber % 26;
                if(remainder == 0){
                    sb.append('Z');
                    quotient --;
                } else {
                    sb.append((char)('A' + remainder - 1));
                }
                columnNumber = quotient;                
            } else {
                sb.append((char)('A' + columnNumber - 1));
                columnNumber = 0;
            }
            
        }
        return sb.reverse().toString();        
    }
}
