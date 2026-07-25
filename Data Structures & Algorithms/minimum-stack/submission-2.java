class MinStack {
    int minVal = Integer.MAX_VALUE;
    public Stack min = new Stack();
    public Stack s;

    public MinStack() {
        s = new Stack();
    }
    
    public void push(int val) {
        s.push(val);
        if (val <= minVal)  {
            minVal = val;
            min.push(val);
        }
    }
    
    public void pop() {
        int val = (Integer) s.pop();
        if (val == (Integer) min.peek()) {
            min.pop();
            if (!min.isEmpty()) {
                minVal = (Integer) min.peek();
            } else {
                minVal = Integer.MAX_VALUE;
            }
            
        }
    }
    
    public int top() {
        return (Integer) s.peek();
    }
    
    public int getMin() {
        return (Integer) min.peek();
    }
}
