class Solution {
    String process(char[] arr, boolean[] blockCommentStart){
        StringBuilder sb  = new StringBuilder();
        int i = 0;
        for(; i<arr.length - 1; i++){
            if(arr[i] == '/' && arr[i+1] == '/'){               
                if(!blockCommentStart[0]){
                    return sb.toString();
                }           
            } else if(arr[i] == '/' && arr[i+1] == '*') {
                if(!blockCommentStart[0]){
                    blockCommentStart[0] = true;
                    i++;
                }
            } else if(arr[i] == '*' && arr[i+1] == '/' && blockCommentStart[0]) {
               blockCommentStart[0] = false;
               i++;
            } else if(!blockCommentStart[0]){
                sb.append(arr[i]);
            }
        }
        if(i == arr.length - 1 && !blockCommentStart[0]){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
    public List<String> removeComments(String[] source) {        
        List<String> result = new ArrayList<>();
        if(source == null || source.length == 0){
            return result;
        }
        boolean[] blockCommentStart = new boolean[]{false};
        for(String line : source){
            boolean origin = blockCommentStart[0];
            String k = process(line.toCharArray(), blockCommentStart);
            if(!k.isEmpty()){
                if(origin &&  !blockCommentStart[0]) {
                    result.set(result.size() - 1, result.get(result.size() -1) + k);
                } else {
                    result.add(k);
                }
            
            }
        }
        return result;
    }
}
