class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty()|| val<=minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if(minstack.peek().equals(stack.peek())){
            minstack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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

class MinStack {
    private Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);  
            min = x;        
        } else {
            stack.push(x - min);  
            if (x < min) {
                min = x; 
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;  
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int) min;  
        } else {
            return (int) (top + min);  
        }
    }

    public int getMin() {
        return (int) min;
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
