class Solution {
    public int minOperations(String[] logs) {
        //I will use a stack. 
        //the bottom of the stack corresponds to the main folder 
        //each item on the stack corresponds to a level above the main folder 
        //at the end the number of items in the stack is the min operations 
        //to get back to main folder 

        Stack<String> stack = new Stack<>();

        for(String log : logs) {
            int indexOfSlash = log.indexOf("/");
            String folder = log.substring(0,indexOfSlash);
            if(folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (folder.equals(".")) {
                //do nothing 
            } else {
                stack.push(folder);
            } 
        }

        return stack.size();
    }
}