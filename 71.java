class Solution {
    public String simplifyPath(String path) {
        
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for(String part : parts){
            if(part.isEmpty() || ".".equals(part)){
                continue; 
            }
            if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {                
                stack.push(part);
            }            
        }
        
        if(stack.isEmpty()){
            return "/";
        }
        
        List<String> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = result.size() -1; i>=0; i--){
            sb.append("/");
            sb.append(result.get(i));
        }
        return sb.toString();
    }
}
