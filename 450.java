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
    
    TreeNode delete(TreeNode node) {
        TreeNode left = node.left;
        node = node.right;
        if(node == null){
            return left;
        }
        if(left != null){
            TreeNode tmp = node;
            while(tmp.left != null){
                tmp = tmp.left;
            }
            tmp.left = left;
        }
        return node;
    }
    
    void search( TreeNode node, int key) {
        if(node == null){
            return;
        } 
        
        if(node.val == Integer.MAX_VALUE){
             if(node.left == null){
                 return;
             }            
             if(node.left.val == key){
                node.left = delete(node.left);
                return;
            } 
            search(node.left, key);          
        } else {
            if (node.val > key && node.left != null ){
                if(node.left.val == key){
                    node.left = delete(node.left);
                }
                else{
                    search(node.left, key);
                }
            }
             if (node.val < key && node.right != null ){
                if(node.right.val == key){
                    node.right = delete(node.right);
                }
                else{
                    search(node.right, key);
                }
            }
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        node.left = root;
        search(node, key);
        return node.left;
    }
}
