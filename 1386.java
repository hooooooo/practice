class Solution {
    
    int maxNumber(int i){
        if((i & 0x1FE) == 0)
            return 2;
        if((i & 0x1E) == 0 || (i & 0x78) == 0 || (i & 0x1E0) ==0){
            return 1;
        }
        return 0;
    }
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] r : reservedSeats){
            int occupancy = map.getOrDefault(r[0], 0);
             occupancy |= 1 << (r[1]  - 1);
            map.put(r[0], occupancy);
        }
        int max = 0;
        for(Integer key : map.keySet()){
           Integer i = map.get(key);
           if((i & 0x1FE) == 0){
             max +=2;
          } else if((i & 0x1E) == 0 || (i & 0x78) == 0 || (i & 0x1E0) ==0){
            max += 1;
          }
        }
        
        max += 2 * (n - map.size());
        return max;
    }
}
