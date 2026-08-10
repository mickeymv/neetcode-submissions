class Solution {
    public int[] sortedSquares(int[] nums) {
        Stack<Integer> negSquares = new Stack<>();
        int[] squares = new int[nums.length];
        int i=0;
        for(int num : nums) {
            if(num<0) {
                negSquares.push(num*num);
            } else {
                int square = num*num;
                if(negSquares.isEmpty()) {
                    squares[i++]=square;
                } else {
                    while(!negSquares.isEmpty() && negSquares.peek()<square) {
                        squares[i++]=negSquares.pop();
                    }
                    
                        squares[i++]=square;
                    
                }
            }
        }
        while(!negSquares.isEmpty()) {
                        squares[i++]=negSquares.pop();
        }
        return squares;
    }
}