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
    void helper(int[]result, TreeNode root, int max) {
        if(root == null){
            return;
        }
        if(root.val >= max){
            max = root.val;
            result[0]++;
        }
        helper(result, root.left, max);
        helper(result, root.right, max);        
    }
    
    public int goodNodes(TreeNode root) {
        int[]result = new int[1];
        helper(result, root, Integer.MIN_VALUE);
        return result[0];
    }
}
