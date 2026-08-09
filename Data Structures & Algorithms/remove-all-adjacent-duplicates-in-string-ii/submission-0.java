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

         for(int i=0;i<s.length();i++) {
            if(stack.isEmpty()) {
                stack.push(new Node(s.charAt(i), 1));
            } else {
                if(stack.peek().ch == s.charAt(i)) {
                    if(stack.peek().freq == k-1) {
                        //delete k-1 
                        while(!stack.isEmpty() && stack.peek().ch==s.charAt(i)) {
                            stack.pop();
                        }
                    } else {
                        stack.push(new Node(s.charAt(i), stack.peek().freq+1));
                    }
                } else {
                    stack.push(new Node(s.charAt(i), 1));
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