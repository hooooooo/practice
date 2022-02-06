class Solution {
    class Node {
        public int val;
        public List<Node> children;
        public List<Node> neighbor;
        public Node(int value){
            this.val = value;
            children = new ArrayList<>(3);
            neighbor = new ArrayList<>(3);
        }
    }
    
    
    void fixTree(Node root){
        for(Node node : root.neighbor){
            root.children.add(node);
            node.neighbor.remove(root);
        }
        root.neighbor.clear();
        for(Node node : root.children){
            fixTree(node);
        }        
    }
    
    Node buildTree(int n, int[][] edges){
        Map<Integer, Node> map = new HashMap<>(n);
        for(int i = 1; i <=n; i++){
            map.put(i, new Node(i));
        }
        for(int[] edge : edges){
            map.get(edge[0]).neighbor.add(map.get(edge[1]));
            map.get(edge[1]).neighbor.add(map.get(edge[0]));
        }
        
        fixTree(map.get(1));        
        return map.get(1);
    }
    
    boolean findPath(List<Node> path, Node node, int target){
        if(node == null){
            return false;
        }
        
        if(node.val == target){
            path.add(node);
            return true;
        }
        
        for(Node child: node.children){
            if(findPath(path, child, target)){
                path.add(node);
                return true;
            }
        }
        return false;
    }
    
     
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Node> path = new ArrayList<>(3);
        Node root =  buildTree(  n,  edges);
        boolean found = findPath(path, root, target);
        if(!found){
            return 0.0f;
        }
        
        if(path.size() - 1  >  t ){
            return 0.0f;
        }
        
        Collections.reverse(path);
        if(!path.get(path.size() -1).children.isEmpty() && t > path.size() - 1){
            return 0;
        }
        
        double result = 1;
        for(int i=1; i<path.size(); i++){
            result *= (double)1.0f / path.get(i-1).children.size();
        }
        
        return result;        
    }
}
