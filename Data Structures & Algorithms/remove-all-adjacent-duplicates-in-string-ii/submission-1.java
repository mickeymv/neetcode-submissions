class Node {
    char ch;
    int freq;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Node(ch,1));
            } else {
                Node top = stack.peek();
                if (top.ch == ch) {

                    if (top.freq == k-1) {

                    //remove the k-1 elements 
                    while(!stack.isEmpty() && stack.peek().ch==ch) {
                        stack.pop();
                    }

                    } else {
                        stack.push(new Node(ch,top.freq+1));
                    }
                } else {
                    stack.push(new Node(ch,1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }

        return sb.reverse().toString();
    }
}