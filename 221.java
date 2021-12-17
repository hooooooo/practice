class Solution {
    public int maximalSquare(char[][] matrix) {
        int row_count = matrix.length;
        int col_count = matrix[0].length;
        
        int[][][] height_tab = new int[row_count][row_count][col_count];
        int[][][] width_tab = new int[col_count][col_count][row_count];
        int max = 0;
        
        for(int r = 0; r<matrix.length; r++){
            for( int c = 0; c<matrix[r].length; c++) {
                if(matrix[r][c] == '0'){
                    continue;
                }
                if(max == 0){
                    max = 1;
                }
                
                // heigh lookup
                int start_r = r;
                while(start_r > 0 && matrix[start_r - 1][c] == '1'){
                    start_r --;
                }   
                
                while(start_r <= r){ 
                    int row_span = r - start_r + 1;
                    height_tab[start_r][r][c] = row_span;
                    if(c - 1 >= 0){
                        height_tab[start_r][r][c] += height_tab[start_r][r][c-1];
                    }
                    if(height_tab[start_r][r][c] >= row_span * row_span){
                        max = Math.max(max, row_span * row_span);    
                    }
                    
                    start_r++;
                }
                
                // width lookup
                int start_c = c;
                while(start_c > 0 && matrix[r][start_c - 1] == '1'){
                    start_c --;
                }                
                while(start_c <= c){
                    int col_span = c - start_c + 1;
                    width_tab[start_c][c][r] = col_span;
                    if(r - 1 >= 0){
                        width_tab[start_c][c][r] += width_tab[start_c][c][r-1];
                    }
                    if(width_tab[start_c][c][r] >= col_span * col_span){
                        max = Math.max(max,  col_span * col_span);
                    }
                    start_c++;
                }                
            }
        }
        
        return max;
    }
}
