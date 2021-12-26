class Solution {
    double distance(int[] pt){
       return  Math.sqrt(Math.pow(pt[0], 2) + Math.pow(pt[1], 2));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            double da = distance(a);
            double db = distance(b);
            if(da == db){
                return 0;
            }
            return da > db ? -1 : 1;
        });   
        
        for(int[] pt : points){
            if(pq.size() < k){
                pq.offer(pt);
                continue;
            } 
            double d = distance(pt);
            if( d < distance(pq.peek()) ) {
                pq.poll();
                pq.offer(pt);
            }
            
        }
        
        int[][] result = new int[pq.size()][2];
        for(int i = 0; i<result.length; i++){
            int[] pt = pq.poll();
            result[i][0] = pt[0];
            result[i][1] = pt[1];
        }
        
        return result;
    }
}
