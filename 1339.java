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
    int buildMap(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null){
            return 0;
        }   
        int sumLeft = buildMap(root.left, map);
        int sumRight = buildMap(root.right, map);
        int sum = root.val + sumLeft + sumRight;
        map.put(root, sum);
        return sum;
    }
    
    
    void search(TreeNode next, Map<TreeNode, Integer> map, long total, long max[]){ 
        if(next == null){
            return;
        }
        long sumL=0, sumR = 0;
        long r = total - map.get(next);
        if(next.left != null){
            sumL = map.get(next.left);
        }
        if(next.right !=  null){
            sumR = map.get(next.right);
        }

        if(sumL > sumR ){
            sumR += next.val + r;
        } else {
            sumL += next.val + r;
        }
        
        long c = sumL * sumR;
        max[0] = Math.max(max[0], c);
        search(next.left, map, total, max);
        search(next.right, map, total, max);
    }
    
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        buildMap(root, map);
        long max[]  = new long[1]; 
        long total = map.get(root);
        search(root, map, total, max);
        return (int)(max[0] % (1000000007L));
    }
}
