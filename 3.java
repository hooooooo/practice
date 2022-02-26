class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int max = 0;
        for(int i = 0; i<arr.length; ){
            int j = i;
            for(; j<arr.length; j++){
                Integer index = map.get(arr[j]);
                if(index == null){
                    map.put(arr[j], j);                    
                    max = Math.max(max, map.size());
                } else {                    
                    map.clear();
                    i = index +1;
                    break;
                }               
            }
            if(j == arr.length){
                break;
            }
        }
        return max;
    }
}
