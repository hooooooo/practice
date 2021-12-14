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
    void helper(TreeNode node, int[]sum, int low, int high){
        if(node == null){
            return;
        }    
        helper(node.left, sum, low, high);
        
        if(node.val >= low && node.val <= high){
            sum[0] += node.val;
        }
        
        if(node.val <= high){
            helper(node.right, sum, low, high);    
        }           
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = new int[1];
        helper(root, sum, low, high);
        return sum[0];
    }
}
