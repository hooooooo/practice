class Solution {
    
    class SillyComparator implements Comparator<Integer>{

            public int compare(Integer s1, Integer s2) {
                    if(s1 < s2){
                        return 1;
                    } else if(s1 > s2){
                        return -1;
                    }
                    return 0;
                }
        }
    
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, 
        new SillyComparator()
        );
        for(int stone : stones){
            pq.offer(stone);
        }
        
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x < y){
                pq.offer(y-x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
