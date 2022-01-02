class Solution {
    public int numPairsDivisibleBy60(int[] time) {
      Map<Integer, Integer>   map = new HashMap<>();
      int count = 0;
      for(int i  =  time.length  - 1; i>=0; i--){
          time[i] %= 60;
          int t = 60 - time[i];
          if(t == 60){
              t = 0;
          }
          if(map.containsKey(t)){
             count += map.get(t);
          }
          int c = map.getOrDefault(time[i], 0) + 1;
          map.put(time[i], c);            
      }
      return count;
    }
}
