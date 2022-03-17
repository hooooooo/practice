class Solution {
    class Record {         
        int sum;
    }
     
    public int scoreOfParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Record> stack = new Stack<>();
        stack.push(new Record());
        for(char ch : arr){
            if(ch == '('){
                stack.push(new Record());
            } else  {
                Record record = stack.pop();
                if(record.sum == 0){
                   record.sum = 1;
                } else {
                    record.sum *= 2;
                }
                stack.peek().sum += record.sum;                
            }
        }
        return stack.peek().sum;
    }
}
