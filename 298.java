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
    int helper(TreeNode node, int current, int[] max){
        if(node == null){
            return current;
        }
        current++;
        
        int t = 0;
        int left = helper(node.left, 0, max);
        max[0] = Math.max(max[0], left);        
        if(node.left != null && node.left.val == node.val + 1) {
            t = left;            
        }
        
        int right = helper(node.right, 0, max);
        max[0] = Math.max(max[0], right);
        if(node.right != null && node.right.val == node.val + 1 && right > t) {
            t = right;            
        } 
        
        max[0] = Math.max(max[0], current  + t);
        return current  + t;
        
    }
    
    public int longestConsecutive(TreeNode root) {
        int[]max = new int[1];
        helper(root, 0, max);
        return max[0];
        
    }
}
