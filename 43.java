class Solution {
    String sum(String s1, String s2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = s2.length() -1,  j =  s1.length() -1; i>=0 || j>=0; i--, j--){
            int result = carry;
            if(i >= 0){
                result += s2.charAt(i) - '0';
            }
            if(j >=0) {
                result += s1.charAt(j) - '0';
            }
            sb.insert(0, result % 10);
            carry = result / 10;
        }
        
        if(carry > 0){
            sb.insert(0, carry);
        }
        return sb.toString();
    }
        
    String helper(char[] num1, int value){
        String result = "";
        String weight = "";
        for(int i = num1.length - 1; i >=0; i--){
            long t =  value * ((num1[i] - '0') );
            result = sum(result, Long.toString(t) + weight);
            weight += "0";
        }
        return result;
    }
    
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return "";
        }
        String weight = "";
        String t = "";
        char[] arr = num1.toCharArray();
        for(int i = num2.length() - 1;i >=0; i--){
            String result = helper(arr, num2.charAt(i) - '0');
            t = sum(t, result + weight);
            weight += "0";
        }
        
        int index = 0;
        while(index < t.length() -1 && t.charAt(index) == '0'){
            index++;
        }
        
        return t.substring(index);
    }
}
