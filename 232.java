class MyQueue {

    Stack<Integer> main = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        main.push(x);
    }
    
    public int pop() {
        while(!main.isEmpty()){
            temp.push(main.pop());
        }
        int i = temp.pop();
        while(!temp.isEmpty()){
           main.push(temp.pop()); 
        }
        return i;
    }
    
    public int peek() {
         while(!main.isEmpty()){
            temp.push(main.pop());
        }
        int i = temp.peek();
        while(!temp.isEmpty()){
           main.push(temp.pop()); 
        }
        return i;
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
