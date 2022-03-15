class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int [] minimal = new int[matrix.length];
        int [] maximal = new int[matrix[0].length];
        for(int r = 0; r<matrix.length; r++){
            int min = matrix[r][0];
            int i = 0;
            for(int c = 0; c<matrix[r].length; c++){
                if(matrix[r][c] < min){
                    min = matrix[r][c];
                    i = c;
                }    
            }
            minimal[r] = i;
        }
        
        for(int c = 0; c<matrix[0].length; c++){
            int max = matrix[0][c];
            int i = 0;
            for(int r = 0; r<matrix.length; r++){
                if(matrix[r][c] > max){
                    max = matrix[r][c];
                    i = r;
                }    
            }
            maximal[c] = i;
        }
        for(int i = 0; i<minimal.length; i++){
            if(maximal[ minimal[i] ] == i){
                result.add(matrix[i][minimal[i]]);
            }
        }
        return result;        
    }
}
