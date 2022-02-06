/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean helper(ListNode node, TreeNode tree) {
        if(node == null){
            return true;
        }
        if(tree == null){
            return false;
        }
        if(node.val != tree.val){
            return false;
        }
        return helper(node.next, tree.left) || helper(node.next, tree.right);        
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(helper(head, root)){
            return true;
        }
        if(root == null){
            return false;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);        
    }
}
