class MyHashMap {
    class Pair{
        public int key;
        public int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    List<List<Pair>> list;
    final static int SIZE = 10000;
    public MyHashMap() {
        list = new ArrayList<List<Pair>>();
        for(int i = 0; i<SIZE; i++){
            list.add(new ArrayList<Pair>());
        }
    }
    
    public void put(int key, int value) {
        int index = key % SIZE;
        List<Pair> pairList = list.get(index);
        for(Pair pair:pairList){
            if(pair.key == key){
                pair.value = value;
                return;
            }
        }
        pairList.add(new Pair(key, value));       
    }
    
    public int get(int key) {
         int index = key % SIZE;
        List<Pair> pairList = list.get(index);
        for(Pair pair:pairList){
            if(pair.key == key){                
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % SIZE;
        List<Pair> pairList = list.get(index);
        int pairIndex = -1;
        for(int i = 0; i<pairList.size(); i++){
            Pair pair = pairList.get(i);
            if(pair.key == key){
                pairIndex = i;
                break;
            }
        }
        if(pairIndex == -1){
            return;
        }
        pairList.remove(pairIndex);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
