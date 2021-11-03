class Item {
    int min;
    int val;        
}

class MinStack {
    
    private Stack<Item> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        Item item = new Item();
        item.val = val;        
        if(stack.isEmpty()){           
            item.min = val;           
        } else {
            item.min = Math.min(val, stack.peek().min);            
        }
        stack.push(item);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
