class Solution {
    class City {
        public int id;
        public Set<Integer> neighbors;
        public City(int _id){
            id = _id;
            neighbors = new HashSet<Integer>();
        }
    }
    
    class Comp implements Comparator<City> {
        
        @Override
        public int compare(City c1, City c2){
           int s1 = c1.neighbors.size();
            int s2 = c2.neighbors.size();
            if(s1 == s2){
                return 0;
            }
            return s1 < s2 ? -1 : 1;
        }
        
    }
    
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, City> cityMap = new HashMap<>(n);
        List<City> order = new ArrayList<>(n);
        for(int i = 0; i<n; i++){
            City city = new City(i);
            cityMap.put(i, city);
            order.add(city);
        }
        
        for(int[] road : roads){
            cityMap.get(road[0]).neighbors.add(road[1]);
            cityMap.get(road[1]).neighbors.add(road[0]);            
        }
        int max = 0;
        Collections.sort(order, new Comp());
        for(int i = order.size()- 1; i>0; i--){
            City city = order.get(i);
            for(int j = i-1; j>=0; j--){
                City city2 = order.get(j);
                int number = city.neighbors.size() + city2.neighbors.size();
                if(city.neighbors.contains(city2.id)){
                    number--;
                }
                max = Math.max(max, number);                
            }
        }
        return max;
    }
}
