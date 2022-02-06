class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if(ch == ')'){
                 if(stack.isEmpty() || stack.peek() !='('){
                     return false;
                 }
                 stack.pop();
            } else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() !='['){
                     return false;
                 }
                 stack.pop();
            } else if(ch == '}'){
                if(stack.isEmpty() || stack.peek() !='{'){
                     return false;
                 }
                 stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
