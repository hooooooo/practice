class Solution {
    class Node {
        public int val;
        public List<Node> children;            
        public Node(int value) {
            val = value;
            children = new ArrayList<>(3);
        }
    }
    
    Node buildTree(int n, int headID, int[] manager){
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i, new Node(i));
        }
        for(int i = 0; i<manager.length; i++){
            if(manager[i] == -1){
                continue;
            }
            map.get(manager[i]).children.add(map.get(i));
        }
        return map.get(headID);
    }
    
    int computeTime(Node root, int[] informTime){
        int time = informTime[root.val];
        int max = 0;
        for(Node child : root.children){
          max = Math.max(max, computeTime(child, informTime));
        }
        return time + max;
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Node tree = buildTree(n, headID, manager);
        return computeTime(tree, informTime);
    }
}
