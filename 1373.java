/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = 0;
    
    void helper(int[] limit, TreeNode node, int[] result){
        if(node == null){
            limit[0] = Integer.MIN_VALUE; // max
            limit[1] = Integer.MAX_VALUE; // min
            result[0] = 1; 
            return;
        }
        int []leftResult = new int[2];
        int [] rightResult = new int[2];
        int [] leftLimit = new int[2];
        int [] rightLimit =new int[2];
        
        helper(leftLimit, node.left, leftResult);
        helper(rightLimit, node.right, rightResult);
        if(leftResult[0] == 1 && rightResult[0] == 1 && 
           node.val > leftLimit[0] && node.val  < rightLimit[1] ){
            result[0] = 1;
            result[1] = node.val  + leftResult[1] + rightResult[1];  
            maxSum = Math.max(maxSum,  result[1]);
            limit[0] = Math.max(node.val, rightLimit[0]);
            limit[1] = Math.min(node.val, leftLimit[1]);                 
        }  
        if(leftResult[0] == 1){
            maxSum = Math.max(maxSum,  leftResult[1]);
        }
        if(rightResult[0] == 1){
            maxSum = Math.max(maxSum,  rightResult[1]);
        }
       
    }
    
    public int maxSumBST(TreeNode root) {
        int [] result = new int[2];
        int [] limit = new int[2];
        helper(limit, root, result);
        return maxSum;
    }
}
