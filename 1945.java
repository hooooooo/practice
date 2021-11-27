class Solution {
    String convert(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            sb.append( Integer.toString(1 + (int)(str.charAt(i) - 'a') ));
        }
        return sb.toString();
    }
    
    String transform(String str){
        int sum = 0;
        for(int i = 0; i<str.length(); i++){
           sum += (1 + (int)(str.charAt(i) - '1'));
        }
        return Integer.toString(sum);        
    }
    
    public int getLucky(String s, int k) {
        String convertedStr = convert(s);
        for(int i = 0; i<k; i++){
            convertedStr = transform(convertedStr);
        }
        return Integer.parseInt(convertedStr);
    }
}
