class CombinationIterator {
    
    private List<String> result = new ArrayList<>();
    private int currentIndex = 0;
    
    void helper(char[] chars, boolean[]used, int index, int len, char[] sb, List<String> result){
        if(index == len){
            result.add(new String(sb));
            return;
        }    
        
        for(int i = 0; i<chars.length; i++){
            if(used[i]){
                continue;
            }
            
            // use the char
            used[i] = true;
            sb[index] = chars[i];
            helper(chars, used, index +1, len, sb, result);
             
            // do not use
            for(int j = i + 1; j<chars.length; j++){
                used[j] = false;
            }
            helper(chars, used, index, len, sb, result);
            
        }
    }
    

    public CombinationIterator(String characters, int combinationLength) {
        char[] chars = characters.toCharArray();
        boolean[] used = new boolean[chars.length];
        char[] sb = new char[combinationLength];
        helper(chars, used, 0, combinationLength, sb, result);
    }
    
    public String next() {
        return result.get(currentIndex++);
    }
    
    public boolean hasNext() {
        return currentIndex < result.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
