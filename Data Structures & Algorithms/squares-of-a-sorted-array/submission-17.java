class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        Stack<Integer> negSqaures = new Stack<>();

        int squaresIndex=0;

        for(int i=0;i<nums.length;i++) {
            int currentSquare = nums[i]*nums[i];
            if(nums[i]<0) {
                negSqaures.push(currentSquare);
            } else {
                while (!negSqaures.isEmpty() && negSqaures.peek()<currentSquare) {
                    squares[squaresIndex++] = negSqaures.pop();
                }
                squares[squaresIndex++]=currentSquare;
            }
        }

        while (!negSqaures.isEmpty()) {
                    squares[squaresIndex++] = negSqaures.pop();
        }

        return squares;
    }
}