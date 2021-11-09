class Solution {
    
    
    int buildBitSet(String str){
        int result = 0;
        for(int i = 0; i<str.length(); i++){
           result |= 1 << (str.charAt(i) - 'a');
        }
        return result;
    }
    
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int []puzzlesBitSet = new int[puzzles.length];
        int []wordBitSet = new int[words.length];
        int i = 0;
        for(String word:words){
            wordBitSet[i++] = buildBitSet(word);
        }
        i = 0;
        for(String puzzle : puzzles){
            puzzlesBitSet[i++] = buildBitSet(puzzle);
        }
        
        List<Integer> result = new ArrayList<>();
        for( i = 0; i<puzzles.length; i++){
            int count = 0;
            for(int j = 0; j<words.length; j++){
                 int t = puzzlesBitSet[i] | wordBitSet[j];
                 if(t != puzzlesBitSet[i]){
                     continue;
                 }
                 int first = 1 << (puzzles[i].charAt(0) - 'a');
                 if((first & wordBitSet[j]) > 0){
                    count++;
                 }   
            }
        
            result.add(count);
        }
        return result;
    }
}
