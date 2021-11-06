class Solution {
 
    final static int NONE = 0;
    final static int Y = 1;
    final static int N = 2;
    
    boolean helper(int[][] edges, int start, int vertex, int[] mem){
        if(mem[vertex] == Y){
            return false;
        }
        
        mem[vertex] = Y;
        if(vertex == start){
            return true;
        }
        
        for(int[] edge: edges){
                if(edge[0] == vertex){
                  if(helper(edges, start, edge[1], mem)){
                      return true;
                  }
                } else if (edge[1] == vertex){
                  if(helper(edges, start, edge[0], mem)){
                      return true;
                  }
                }                
        }  
        return false;
        
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        int[] mem = new int[n];
        helper(edges, start, end, mem);
        return mem[start] == Y;
    }
}
