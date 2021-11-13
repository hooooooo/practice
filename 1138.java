class Solution {
    
     
    void search(Map<Character, int[]> map, char from, char to, StringBuilder sb){
        int[] fromIndex = map.get(from);
        int[] toIndex = map.get(to);
        if(to >= from){
            for(int i = 0; i< Math.abs(toIndex[1] - fromIndex[1]); i++){
                if(toIndex[1] > fromIndex[1]){
                    sb.append("R");
                } else {
                    sb.append("L");
                }
            }    
            
            for(int i = 0; i< toIndex[0] - fromIndex[0]; i++){
                sb.append("D");
            }    
            
        } else {
            for(int i = 0; i< fromIndex[0] - toIndex[0]; i++){
                sb.append("U");
            }
            for(int i = 0; i< Math.abs(toIndex[1] - fromIndex[1]); i++){
                if(toIndex[1] > fromIndex[1]){
                    sb.append("R");
                } else {
                    sb.append("L");
                }
            }    
        }
        sb.append("!");
    }
    
    public String alphabetBoardPath(String target) {
        Map<Character, int[]> map = new HashMap<>(26);
        char[][] board = new char[6][];
        for(int i = 0; i<board.length; i++){
            if(i == board.length - 1){
                board[i] = new char[1];
                board[i][0] = 'z'; 
                int[] indexs = new int[2];
                indexs[0] = i;
                indexs[1] = 0;
                map.put('z', indexs);
            } else {
                board[i] = new char[5];
                for(int j = 0; j<board[i].length; j++){
                    int[] indexs = new int[2];
                    char ch = (char)('a' + i * 5 + j);
                    board[i][j] =  ch;
                    indexs[0] = i;
                    indexs[1] = j;
                    map.put(ch, indexs);
                }
            }     
        }
            
        StringBuilder sb = new StringBuilder();
        char[] targetArr = target.toCharArray();
        for(int i = 0; i<targetArr.length; i++){
            StringBuilder tmp = new StringBuilder();
            if(i ==0){
                search(map, 'a', targetArr[i], tmp);
            } else {
                search(map, targetArr[i-1], targetArr[i], tmp);
            }
            sb.append(tmp.toString());
        }
        return sb.toString();
    }
}
