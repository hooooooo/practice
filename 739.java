class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null){
            return null;
        }
        int temp[] = new int[71];
        for(int i = 0; i<temp.length; i++){
            temp[i] = Integer.MAX_VALUE;
        }
        int result[] = new int[temperatures.length];
        for(int i = temperatures.length - 1; i>=0; i--){
           int t = temperatures[i];
           if(i< temp[t- 30]){
               temp[t-30] = i;
           } 
           int index = Integer.MAX_VALUE;
           for(int j = t - 30 + 1; j<temp.length; j++ ){ 
               index = Math.min(index, temp[j]);
           }
           if(index != Integer.MAX_VALUE){
               result[i] = index - i;
           }
        }
        return result;
    }
}
