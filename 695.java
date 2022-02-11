class Solution {
    int findParent(Map<Integer, Integer> parent, int i){
        Integer value = parent.get(i);
        if(value == null){
            return i;
        }
        return findParent(parent, value);
    }
    
    void union(Map<Integer,Integer> parent, int y, int x){
        int p = findParent(parent, x);
        parent.put(p, y);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int num = 0;
        
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0){
                    continue;
                }
                
                if(r > 0 && grid[r-1][c] != 0
                  && c > 0 && grid[r][c-1] != 0){                     
                  int pr = findParent(parent, grid[r-1][c]);
                  int pc = findParent(parent, grid[r][c-1]);
                  if(pr != pc){
                      union(parent, pc, pr);  
                      count.put(pc, count.get(pc) + count.get(pr) + 1);
                  } else {
                      int cc = count.get(pr);
                      count.put(pr, cc + 1);                      
                  }
                  grid[r][c] = grid[r-1][c];
                } else if(r > 0 && grid[r-1][c] != 0) {
                    grid[r][c] = grid[r-1][c];
                    int p = findParent(parent, grid[r][c]);
                    int cc = count.get(p);
                    count.put(p, cc+1);
                } else  if(c > 0 && grid[r][c-1] != 0) {
                    grid[r][c] = grid[r][c-1];
                    int p = findParent(parent, grid[r][c]);
                    int cc = count.get(p);
                    count.put(p, cc+1);
                } else {
                   grid[r][c] = ++num;
                   count.put(grid[r][c], 1);
                }
            }
        }
        
        int max = 0;
        for(int value : count.values()){
            max = Math.max(max, value);
        }
        
        return max;
    }
}
