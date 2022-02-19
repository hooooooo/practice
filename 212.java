class Solution {
    
    
    boolean search(boolean[][] visited,  char[][] board, int r, int c, char[] word, int index){        
        if(r < 0 || r >= board.length || c < 0|| c >= board[r].length || board[r][c] != word[index]) {
            return false;
        }
        
        index ++;        
        if(index == word.length){
            return true;
        }
        
        visited[r][c] = true;
        boolean ret = false;        
        if(c > 0 && !visited[r][c-1]) {
              ret = search(visited,  board,  r,  c - 1, word, index); 
        }
        if(!ret && c < board[r].length - 1 && !visited[r][c+1]) {
              ret = search(visited,  board,  r,  c + 1, word, index);            

        }

        if(!ret && r > 0 && !visited[r - 1][c]) {
              ret = search(visited,  board,  r - 1,  c, word, index);            

        }

        if(!ret && r < board.length - 1 && !visited[r + 1][c]) {
             ret = search(visited,  board,  r + 1,  c, word, index);            
        }
         
       visited[r][c] = false; 
       return ret;
         
    }
    
    public List<String> findWords(char[][] board, String[] words) {
       boolean[][] visited = new boolean[board.length][board[0].length];
       List<String> result = new ArrayList<>();
       boolean[] found = new boolean[words.length];
        
       for(int r = 0; r<board.length ; r++){
           for(int c = 0; c<board[0].length; c++){
               for(int i = 0; i<words.length; i++){
                   String word = words[i];
                   if(found[i]){
                       continue;
                   }
                    char[]wordArr = word.toCharArray();
                    found[i]  = search(visited, board, r, c, wordArr, 0);
                    if(found[i] ){
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }
}
