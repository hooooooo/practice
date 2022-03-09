class Solution {
    class Node {
        public int number;
        public Set<Node> neighbers = new HashSet<>(3);
        public Node(int number){
            this.number = number;
        }
    }
    
    int search(Node node, Node target, boolean[]visited){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Node neighbor = queue.poll();
                if(neighbor.number == target.number){
                    return count;
                }
                visited[neighbor.number] = true;
                for(Node child : neighbor.neighbers){
                    if(visited[child.number]){
                        continue;
                    }
                    queue.offer(child);
                }                
            }
            count++;
        }
        return -1;
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        Map<Integer, Set<Node>> stopBusMap = new HashMap<>();
        Node[] nodes = new Node[routes.length];
        for(int i = 0; i<nodes.length; i++){
            nodes[i] = new Node(i);
        }
        
        for(int i = 0; i<routes.length; i++){
            Node node = nodes[i];
            for(int stop: routes[i]){
                Set<Node> buses = stopBusMap.get(stop);
                if(buses == null){
                    buses = new HashSet<Node>(3);
                    stopBusMap.put(stop, buses);
                }
                buses.add(node);                
            }
        }
        
        for(Set<Node> buses : stopBusMap.values()){
            for(Node node : buses){
                 for(Node node1 : buses){
                    if(node1 == node){
                        continue;
                    }
                    node.neighbers.add(node1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        boolean[]visited = new boolean[routes.length];
        
        Set<Node> sourceBuses = stopBusMap.get(source);
        Set<Node> targetBuses = stopBusMap.get(target);
        if(sourceBuses == null || targetBuses == null){
            return -1;
        }
        
        for(Node sourceNode : sourceBuses) {
            for(Node targetNode : targetBuses){
                for(int i = 0; i<visited.length; i++){
                    visited[i] = false;
                }
                int result = search(sourceNode, targetNode, visited);
                if(result >= 0){
                    min = Math.min(min, result);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        
        
        return min;        
    }
}
