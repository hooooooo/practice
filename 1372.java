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
    
    int[] helper(TreeNode node, int[]max){
        if(node == null){
            return new int[2];
        }
        int left[] = helper(node.left, max);
        int right[] = helper(node.right, max);
        int result [] = new int[2];
        result[0] = 1 + left[1];
        result[1] = 1 + right[0];
        
        max[0] = Math.max(max[0], result[0] -1);
        max[0] = Math.max(max[0], result[1] -1);
        return result;
    }
    
    public int longestZigZag(TreeNode root) {
        int max[] = new int[1];
        helper(root, max);
        return max[0];
    }
}
