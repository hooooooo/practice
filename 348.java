class TicTacToe {
    private int [][] matrix;

    public TicTacToe(int n) {
        matrix = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        matrix[row][col] = player;
        return DoesPlayerWin(player, row, col);
    }
    
    private int DoesPlayerWin(int player, int row, int col){
        // horizontal and vertical scan
        boolean win = true;
        for(int r = 0; r<matrix.length && win; r++){
            if(matrix[r][col] != player){
                win = false;
            }
        }
        if(win){
            return player;
        }
        
        win = true;
        for(int c = 0; c<matrix.length && win; c++){
            if(matrix[row][c] != player){
                win = false;
            }
        }
        if(win){
            return player;
        }
 
        win = true;
        for(int r = 0; r<matrix.length && win; r++){
           if(player != matrix[r][matrix.length - 1 - r]){
               win = false;
           }            
        }
        if(win){
            return player;
        }
        
        win = true;
        for(int r = 0; r<matrix.length && win; r++){
           if(player != matrix[r][r]){
               win = false;
           }            
        }
       
        return win ? player : 0;        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
