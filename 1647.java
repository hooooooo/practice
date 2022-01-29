class Solution {
    public int minDeletions(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, List<Character>> countMap = new HashMap<>();
        char[] arr = s.toCharArray();
        
        for(char ch : arr){
            int count = map.getOrDefault(ch, 0);
            count++;
            map.put(ch, count);
        }
        
        List<Integer> dupKey = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            List<Character> list = countMap.get(entry.getValue());    
            if(list == null){
                list = new ArrayList<Character>();
                countMap.put(entry.getValue(), list);
            } else if(list.size() == 1){
                dupKey.add(entry.getValue());
            }
            
            list.add(entry.getKey());
        }
        // resolve duplicated key
        for(int key : dupKey){
            int dupCharCount = countMap.get(key).size();
            for(int c = 0; c < dupCharCount-1; c++){
                int i = key - 1;
                for(; i>=0; i--){
                    if(!countMap.containsKey(i)){
                        break;
                    }   
                }
                result += key - i;
                if(i != 0){
                    countMap.put(i, null);
                }                
            }            
        }
        return result;
    }
}
