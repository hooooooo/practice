class Solution {
    
    int findParent(int[]parent, int i){
        if(parent[i] == -1){
            return i;
        }
        return findParent(parent, parent[i]);
    }
    
    void union(int[]parent, int x, int y){
        parent[y] = x;
    }
    
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];    
        for(int i = 0; i<n; i++){
            parent[i] = -1;
        }
        for(int[] edge : edges){
            int x = findParent(parent, edge[0]);
            int y = findParent(parent, edge[1]);
            if(x == y){
                return false;
            }
            union(parent, x, y);
        }
        
        int p = -1;
        for(int i = 0; i<n; i++){
            int t = findParent(parent, i);    
            if(p == -1){
                p = t;
            } else if(p != t){
                return false;
            }
        }
        return true;        
    }
}
