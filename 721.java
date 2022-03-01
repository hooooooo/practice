class Solution {
    
    class Node {
        public List<String> account;
        public int index;
        public Node parent;
        public List<Node> children = new ArrayList<>();
    }
    
    
    
    Node findParent(Node node){
        while(node.parent != null){
            node = node.parent;
        }
        return node;
    }
    
    void dumpNode(Node node, List<String> account){
         for(int j = 1; j<node.account.size(); j++){
             String email = node.account.get(j);
            if(!account.contains(email)){
                account.add(email);
            }
         }
        for(Node child : node.children){
            dumpNode(child, account);
        }
    }
    
    void mergeNode(Node parent,  Node child, Set<Integer> mergedIndex){
        child.parent = parent;
        parent.children.add(child);
        mergedIndex.add(child.index);        
    }
    
   void mergeAccount(List<List<String>> group, List<List<String>> result){
        
        Set<Integer> mergedIndex = new HashSet<>();
        List<Node> nodes = new ArrayList<>(group.size());
        for(int i = 0; i<group.size(); i++){
            Node node = new Node();
            node.index = i;
            node.account = group.get(i);
            nodes.add(node);
        }
        
        Map<String, Node> map = new HashMap<>();
        for(int i = 0; i<group.size(); i++){
            Node node = nodes.get(i);
            Node existingNode = null;           
            for(int j = 1; j<node.account.size(); j++){
               String email = node.account.get(j);
               existingNode = map.get(email);
               if(existingNode != null){
                   Node p1 = findParent(node);
                   Node p2 = findParent(existingNode);
                   if(p1 != p2){
                       mergeNode(p1, p2, mergedIndex);
                   }
               } else {
                   map.put(email, node);
               }
            }
        }
        
        for(int i = 0; i<nodes.size(); i++){
             if(mergedIndex.contains(i)){
                 continue;
             }
            List<String> account = new ArrayList<>();
            Node parent = findParent(nodes.get(i));
            dumpNode(parent, account);
            Collections.sort(account);
            account.add(0, parent.account.get(0));
            result.add(account);            
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>> > accountMap = new HashMap<>();
        for(List<String> account : accounts){
            List<List<String>>  list = accountMap.get(account.get(0));
            if(list == null){
                list = new ArrayList<List<String>>();
                 accountMap.put(account.get(0), list); 
            }
            list.add(account);
        }
        
       List<List<String>> result = new ArrayList<List<String>>(); 
        for(String key : accountMap.keySet()){
               mergeAccount(accountMap.get(key), result);
        }
        return result;
        
    }
}
