class Solution {
    boolean binarySearch(int[][] matrix, int row, int target){
        int l = 0;
        int r = matrix[row].length - 1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0; 
        int r = matrix.length - 1;
        int lastIndex = matrix[0].length - 1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][lastIndex]){
                return binarySearch(matrix, mid, target);
            }
            
            if(matrix[mid][0] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }            
        }
        return false;        
    }
}
