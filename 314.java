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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int rootIndex = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        
        if(root != null){
            queue.offer(root);
            index.offer(0);
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                int t = index.poll();
                
                if(t >= 0){
                    if(result.size() - rootIndex == t){
                        result.add(new ArrayList<Integer>());
                    }
                    result.get(rootIndex + t).add(node.val);
                } else {
                    int j = rootIndex + t;
                    if(j<0){
                        rootIndex++;
                        j++;
                        result.add(0, new ArrayList<Integer>());
                    }
                    result.get(j).add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                    index.offer(t - 1);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    index.offer(t + 1);
                }                
            }            
        }
        
        return result;
    }
}
