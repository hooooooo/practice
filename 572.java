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
    
    
    boolean helper(TreeNode node, TreeNode subNode){
        if( node == null ^ subNode == null){
            return false;
        }
        if(node == null){
            return true;
        }
        if(node.val != subNode.val){
            return false;
        }
        return helper(node.left, subNode.left) && helper(node.right, subNode.right);
    }
    
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(helper(root, subRoot)){
            return true;
        }
        if(root == null ){
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
}
