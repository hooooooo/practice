class Solution {
    
    String filter(String word){
        Set<Character> toRemove = new HashSet<>();
        toRemove.add('!');
        toRemove.add('?');
        toRemove.add('\'');
        toRemove.add(',');
        toRemove.add(';');
        toRemove.add('.');
        
        char arr[] = word.toCharArray();
        int index = 0;
        for(int i = 0; i<arr.length; i++){
            if(toRemove.contains(arr[i])){
                arr[index++] = ' ';
            } else {
                arr[index++] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr, 0, index);
    }
    
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(String word : banned){
            bannedSet.add(word);
        }
        int max = 0;
        String result = null;
        Map<String, Integer> freqMap = new HashMap<>();
        String filtered = filter(paragraph);
        String[] strings = filtered.split(" ");
        for(String word: strings){
            if(word.isEmpty() ||  word.equals(" ") || bannedSet.contains(word)){
                continue;
            }
            Integer freq = freqMap.getOrDefault(word, 0);
            freq ++;
            if(freq > max){
                max = freq;
                result = word;
            }
            freqMap.put(word, freq);            
        }
        return result;        
    }
}
