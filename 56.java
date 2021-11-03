class Solution {
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,  (int[] i1, int[] i2)-> {
            if(i1[0] == i2[0]) return 0;
            return i1[0] < i2[0] ? - 1 : 1;
        });
        
        List<int[]> result = new ArrayList<>();
        if(intervals.length > 0){
            int[] tmp =  intervals[0];
            for(int i = 1; i<intervals.length; i++){
                if(intervals[i][0] <= tmp[1]) {
                    tmp[1] = Math.max(tmp[1], intervals[i][1]);
                } else {
                    result.add(tmp);
                    tmp = intervals[i];
                }
            }
            result.add(tmp);
        }
        int[][] finalResult = result.toArray(new int[0][0]);
        return finalResult;
    }
}
