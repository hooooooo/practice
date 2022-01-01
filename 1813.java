class Solution {
    
    // align to front
    // case 1:   
    //   [abc]
    //   [abcdef]
    // case 2:
    //    [ab      c]
    //    [abxxxxxxc]
    // align to back
    //    [        abc]
    //    [def     abc]
    
    
    boolean align(String []longWords, String []shortWords){
        // case 1
        int l = -1;
        int r = longWords.length;
        for(int i = 0; i<shortWords.length; i++){
            if(!shortWords[i].equals(longWords[i])){
                break;
            }
            l = i;
            if(i == shortWords.length - 1){
                return true;
            }
        }
        // case 2 
        int offset = longWords.length - shortWords.length;
        for(int i = shortWords.length - 1; i>=0; i--){
            if(!shortWords[i].equals(longWords[i + offset])){
                break;
            }
            r = i + offset;
            if(i == 0){
                return true;
            }
        }
        
        return  shortWords.length ==  (l + 1 + (longWords.length - r));
    }
    
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)){
            return true;
        }
        String []words1 = sentence1.split(" ");
        String []words2 = sentence2.split(" ");
        String []longWords = words2;
        String []shortWords = words1;
        if(words1.length > words2.length){
            longWords = words1;
            shortWords = words2;
        }
        return align(longWords, shortWords);
    }
}
