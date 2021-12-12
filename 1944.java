class Solution {
    
    
    int prepare(List<Integer> list,  int h){
        int l = 0; 
        int r = list.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(h < list.get(m)){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        int visibleCount = list.size() - l;
        int tmp = visibleCount;
        if(visibleCount  < list.size()){
            visibleCount ++;
        }
            
        int rmIndex = list.size() -1;
        
        while(tmp -- > 0){
            list.remove(rmIndex);            
            rmIndex --;
        }
        
        list.add(h);
        return visibleCount;
    }
    
    public int[] canSeePersonsCount(int[] heights) {
        int[]result = new int[heights.length];
        List<Integer> list = new ArrayList<>();
        for(int i = heights.length-1; i >= 0; i--){
            result[i] =  prepare(list, heights[i]);            
        }
        
        return result;
    }
}
