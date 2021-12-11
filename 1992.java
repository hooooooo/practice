class Solution {

    
    void fill(int[] rect, int[][]land, int r, int c){
        if(r < 0 || r == land.length || c < 0 || c == land[r].length || land[r][c] != 1){
            return;
        }
        land[r][c] = 2;
        rect[0] = Math.min(r, rect[0]);
        rect[1] = Math.min(c, rect[1]);
        rect[2] = Math.max(r, rect[2]);
        rect[3] = Math.max(c, rect[3]);
        fill(rect, land, r + 1, c);
        fill(rect, land, r - 1, c);
        fill(rect, land, r, c + 1);        
        fill(rect, land, r, c - 1);        
    }
    
    
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        for(int r = 0; r <land.length; r ++){
            for(int c = 0; c<land[r].length; c++){
                if(land[r][c] != 1){
                    continue;
                }
                
                int[] rect = new int[4];
                rect[0] = rect[2] = r;
                rect[1] = rect[3] = c;
                fill(rect, land, r, c);
                result.add(rect);
            }
        }        
        int[][] tmp = new int[result.size()][4];
        for(int i = 0; i<result.size(); i++){
            int[]rect = result.get(i);
            tmp[i][0] = rect[0];
            tmp[i][1] = rect[1];
            tmp[i][2] = rect[2];
            tmp[i][3] = rect[3];            
        }
        return tmp;        
    }
}
