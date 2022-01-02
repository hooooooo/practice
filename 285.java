/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    void helper(TreeNode node, TreeNode target, TreeNode[] cache){
        if(node == null || cache[1] != null){
            return;
        }        
        helper(node.left, target, cache);
        if(cache[1] != null){
            return;
        }
        
        if(cache[0] != null && cache[0].val == target.val){
            cache[1] = node;
            return;
        }
        
        cache[0] = node;        
        helper(node.right, target, cache);
     }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode [] cache = new TreeNode[2];
        helper(root, p, cache);
        return cache[1];
    }
}
