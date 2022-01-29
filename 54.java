class Solution {
    private static final int DIR_RIGHT = 0;
    private static final int DIR_DOWN = 1;
    private static final int DIR_LEFT = 2;
    private static final int DIR_UP = 3;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        // right (top ++), down (right --), left (bottom -- ), up ->  (left ++) 
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int dir = DIR_RIGHT;
        while(bottom >= top && right >= left){
            if(dir == DIR_RIGHT){
                for(int  i = left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
            } else if(dir == DIR_DOWN){
                for(int  i = top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            } else if(dir == DIR_LEFT){
                for(int  i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else if(dir == DIR_UP){
                for(int  i = bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            } 
            dir ++;
            dir %= 4;
        }
        return result;
        
    }
}
