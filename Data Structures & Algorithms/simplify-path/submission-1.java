class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for(String directory : directories) {
            if(directory.isEmpty()) {
                continue;
            }
            if (directory.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop(); // go up one level 
                }
            } else if (directory.equals(".")) {
                //skip current directory 
                continue;
            }           else {
                stack.push(directory);
            }
        }

        String simplePath="";

        while(!stack.isEmpty()) {
            String directory = stack.pop();
            simplePath = "/" + directory + simplePath;
        }

        if(simplePath.isEmpty()) {
            return "/";
        } else {
            return simplePath;
        }
    }
}