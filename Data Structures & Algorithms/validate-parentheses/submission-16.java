class Solution {

    Map<Character, Character> leftToRightPs = new HashMap<>();
    {
        leftToRightPs.put('(', ')');
        leftToRightPs.put('{', '}');
        leftToRightPs.put('[', ']');
    }


    public boolean isValid(String s) {
        Stack<Character> leftPs = new Stack<>();

        for(char p:s.toCharArray()) {
            if(leftToRightPs.keySet().contains(p)) {
                leftPs.push(p);
            } else {
                if (leftPs.isEmpty()) {
                    return false;
                }
                Character topLeftP = leftPs.peek();
                if(leftToRightPs.get(topLeftP)!=p) {
                    return false;
                } else {
                    leftPs.pop();
                }
            }
        }

        if(!leftPs.isEmpty()) {
            return false;
        }

        return true;
    }
}
