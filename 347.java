class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((p1, p2)->{
            return Integer.compare(p1.get(0), p2.get(0));
        });
        
            
        int pre = nums[0];
        int count = 1;
        
        for(int i=1; i<= nums.length; i++){ 
            if(i == nums.length || nums[i] != pre){
                if(pq.size() < k || (pq.size() > 0 && count > pq.peek().get(0))) {
                       List<Integer> m = new ArrayList<>(3);
                       m.add(count);
                       m.add(pre); 
                       pq.offer(m);
                   
                }
                
                if(pq.size() > k){
                    pq.poll();
                }
                
                if(i < nums.length){
                    pre = nums[i];
                    count = 1;
                }
            }
            else {
                count++;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().get(1));
        }    
        int[] a = new int[result.size()];
        for(int i = 0; i<a.length; i++){
            a[i] = result.get(i);
        }
        return a;
    }
}
