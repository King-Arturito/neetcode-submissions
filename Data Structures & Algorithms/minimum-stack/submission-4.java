class MinStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> min;
    int minVal = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (val <= minVal) {
            minVal = val;
            min.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
            if (!min.isEmpty()) {
                minVal = min.peek();
            } else {
                minVal = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
