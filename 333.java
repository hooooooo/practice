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
    private int max = 0;
    
    boolean isBst(int[]count, TreeNode node, int[] limit){
        if(node == null){
            return true;
        }
 
        int[]countLeft = new int[1];
        int[] limitLeft =  {Integer.MIN_VALUE, Integer.MAX_VALUE};
        boolean left = isBst(countLeft, node.left, limitLeft);
        if(left){
            max = Math.max(max, countLeft[0]);
        }
        
        int[]countRight = new int[1];
        int[] limitRight =  {Integer.MIN_VALUE, Integer.MAX_VALUE};
        boolean right = isBst(countRight, node.right, limitRight);        
        if(right){
            max = Math.max(max, countRight[0]);
        }
        
        if(left && right &&
          node.val > limitLeft[0] &&
          node.val  < limitRight[1]
          ){
           count[0] += 1 + countLeft[0] + countRight[0];
           max = Math.max(max, count[0]);
           limit[0] = Math.max(limitLeft[0], limitRight[0]);
           limit[0] = Math.max(node.val,  limit[0]);
            
           limit[1] = Math.min(limitRight[1], limitLeft[1]);
          limit[1] = Math.min(node.val,  limit[1]);
           
           return true;
        }
        return false;       
    }
    
    
    public int largestBSTSubtree(TreeNode root) {
        int[] count = new int[1];
        int[] limit =  {Integer.MIN_VALUE, Integer.MAX_VALUE};
        isBst(count, root, limit);
        return max;
    }
}
