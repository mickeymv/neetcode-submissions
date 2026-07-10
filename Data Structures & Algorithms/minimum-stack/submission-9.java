
public record Node(int val, int min) {} 

class MinStack {

    Stack<Node> stack = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        int currentMin = Integer.MAX_VALUE;
        if(!stack.isEmpty()) {
            currentMin = stack.peek().min();
        }
        currentMin = Math.min(currentMin, val);
        stack.push(new Node(val, currentMin));
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().val();
    }
    
    public int getMin() {
        return stack.peek().min();
    }
}
