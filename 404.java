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
    void helper(TreeNode root, boolean isLeft, int[] result){
        if(root == null){
            return;
        }
        if(isLeft && root.left == null && root.right == null){
            result[0] += root.val;
        }
        helper(root.left, true, result);
        helper(root.right, false, result);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int[] result = new int[1];
        helper(root, false, result);
        return result[0];
    }
}
