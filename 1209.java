class Solution {
    
    class Pair{
        char ch;
        int count;        
        Pair(char ch){
            this.ch = ch;
            count = 1;
        }
    }
    
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(new Pair(arr[i]));
            } else if(stack.peek().ch !=  arr[i]){
                stack.push(new Pair(arr[i]));
            } else {
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            }            
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            sb.insert(0, ("" + pair.ch).repeat(pair.count));
        }
        
        return sb.toString();
    }
}
