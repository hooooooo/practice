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
    
    int helper(int[] tilt, int[]sum,  TreeNode node){
        if(node == null){
            return 0;
        }    
        
        int[] leftTilt = new int[1];
        int []leftSum = new int[1];
        int[]rightTilt = new int[1];
        int[]rightSum = new int[1];
        int l = helper(leftTilt, leftSum, node.left);
        int r = helper(rightTilt, rightSum, node.right);
        tilt[0] = Math.abs(leftSum[0] - rightSum[0]);
        sum[0] = node.val  + leftSum[0] + rightSum[0];
        return tilt[0] + l + r;        
    }
    
    public int findTilt(TreeNode root) {
        int[]tilt = new int[1];
        int[]sum = new int[1];
        return helper(tilt, sum, root);        
    }
}
