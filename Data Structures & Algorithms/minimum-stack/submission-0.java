class StackEntry {
    int currentVal;
    int min;

    public StackEntry(int cv, int m) {
        this.currentVal = cv;
        this.min = m;
    }
}

class MinStack {
    private Stack<StackEntry> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new StackEntry(val, val));
        }  else {
            stack.push(new StackEntry(val, Math.min(this.getMin(), val)));
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().currentVal;        
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
