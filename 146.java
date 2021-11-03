class Node {
    int val;
    int key;
    Node next;
    Node prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);
    
    
    private void add(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;        
    }
    
    private void moveToTop(Node node){
        if(head.next == node){
            return;
        }
        
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
        
        add(node);
    }
    
    private void removeLast(){
        Node last = tail.prev;
        Node prev = last.prev;
        prev.next = tail;
        tail.prev = prev;        
        map.remove(last.key);
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToTop(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(key, value);
            map.put(key, node);
            add(node);
            if(map.size() > capacity){
                removeLast();
            }
        } else {
            node.val = value;
            moveToTop(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
