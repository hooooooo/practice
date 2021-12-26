class Solution {
    List<Integer> convert(List<String> arr) {
        List<Integer> result = new ArrayList<>();         
        for(int j = 0; j<arr.size(); j++){
            int o = 0;
            String s = arr.get(j);
            boolean unique = true;
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                int bit = (1 << (int)(c - 'a'));
                if((o & bit) > 0 ){
                    unique = false;
                    break;
                }
                o |= bit;
            }  
            
            if(unique){
               result.add(o);
               result.add(s.length());
            }
        }
        return result;
    }
    
    int helper(List<Integer> arr, int i, int max, int result){
        if(i == arr.size()/2) {
            return max;
        }
        int taken = 0;
        if( (arr.get(i*2) & result) == 0 ){
           taken = helper(arr, i + 1, max + arr.get(i*2 + 1), result | arr.get(i*2));
        }
        int notTaken = helper(arr, i + 1, max, result);
        return Math.max(taken, notTaken);
    }
    
    
    public int maxLength(List<String> arr) {
        List<Integer> n = convert(arr);
        return helper(n, 0, 0, 0);
        
    }
}
