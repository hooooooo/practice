class Solution {
    // A uses X
    // B uses O
    // return who make the last move
    static  final int X = 1;
    static  final int O = 2;
    
    boolean render(int[][]chess, int[][] moves){
        boolean useX = true; 
        for(int[] move : moves){
            chess[move[0]][move[1]] = useX ?X :O;
            useX = !useX;
        }
        return !useX;
    }
    
    String isWin(int[][]chess, int[] lastMove){
        int lastMover = chess[lastMove[0]][lastMove[1]] ;
        boolean xMovesLast = lastMover == X;
        int row = lastMove[0];
        boolean win = true;
        for(int i = 0; i<3; i++){
            if(chess[row][i] != lastMover){
                win = false;
                break;
            }
        }
        
        if(win){
            return xMovesLast ? "A" : "B";
        }
        win = true;
        for(int i = 0; i<3; i++){
            if(chess[i][lastMove[1]] != lastMover){
                win = false;
                break;
            }
        }
        if(win){
            return xMovesLast ? "A" : "B";
        }
                
        win = true;
        for(int i = 0; i<3; i++){
            if(chess[i][i] != lastMover){
                win = false;
                break;
            }
        }
        if(win){
            return xMovesLast ? "A" : "B";
        }

        win = true;
        for(int i = 0; i<3; i++){
            if(chess[2 - i][i] != lastMover){
                win = false;
                break;
            }
        }
        if(win){
            return xMovesLast ? "A" : "B";
        }
        
        
        return "Draw";        
    }
    
    public String tictactoe(int[][] moves) {
        int[][]chess = new int[3][3];
        render(chess, moves);
        String result =  isWin(chess, moves[moves.length-1]);
        if(result.equals("Draw") && moves.length < 9){
          return "Pending";
        }
        return result;
        
    }
}
