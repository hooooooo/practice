class Solution {
    int helper(int startIndex, Map<Character, Integer> map, char[] arr){
        int endIndex = map.get(arr[startIndex]);
        int i = startIndex + 1;
        for(; i<endIndex && i<arr.length; i++){
            endIndex = Math.max(endIndex, map.get(arr[i]));
        }
        return endIndex - startIndex + 1;
    }
    
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = arr.length - 1; i>=0; i--){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
            }
        }
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            int len = helper(i, map, arr);
            result.add(len);
            i += len;
        }
        return result;        
    }
}
