class Solution {
    
    void search(List<List<Integer>> result, List<Integer> current, int i, int n, int[][] graph){
        current.add(i);
        if(i == n){
            result.add(new ArrayList<Integer>(current));
        } else {
            for(int v : graph[i]){
                search(result, current, v, n, graph);
            }
        }
        current.remove(current.size() -1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        search(result, current, 0, graph.length-1, graph);
        return result;
    }
}
