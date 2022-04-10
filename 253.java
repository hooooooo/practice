class Solution {
    int[] findMeeting(int startTime, List<int[]> intervals){
        int l = 0;
        int r = intervals.size() - 1;
        int i = -1;
        while(l<=r){
            int m = l + (r - l) / 2;
            if(intervals.get(m)[0] == startTime){
                i = m;
                break;
            }
            if(intervals.get(m)[0]  < startTime){
                l = m + 1;
            } else {
                i = m;
                r = m - 1;
            }
        }
        
        if(i == -1){
            return null;
        }
        
        int[] res = new int[]{intervals.get(i)[0], intervals.get(i)[1]};
        intervals.remove(i);
        return res;
    }
    
    public int minMeetingRooms(int[][] intervals) {
     Arrays.sort(intervals, new Comparator<int[]>() {
         @Override
         public int compare(int[] a, int []b){
             if(a[0] < b[0]){
                 return -1;
             } else if(a[0] > b[0]){
                 return 1;
             }
             if(a[1] < b[1]){
                 return -1;
             } else if(a[1] > b[1]){
                 return 1;
             }
             return 0;
         }
         
     });
     List<int[]> meetings = new ArrayList<>(intervals.length);
     for(int[] meeting : intervals){
         meetings.add(meeting);
     }
        
     int rooms = 0;
     while(!meetings.isEmpty()){
         rooms ++;
         int startTime = 0;         
         while(true){
             int[] meeting = findMeeting(startTime, meetings);
             if(meeting == null){
                 break;
             }
             startTime = meeting[1];
         }
     }
        
    return rooms;
    }
}
