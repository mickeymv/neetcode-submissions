class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];



        for(int box=0;box<boxes.length();box++) {
            int movesToMoveBallToBox = 0;
            for(int ball=0;ball<boxes.length();ball++) {
                if(boxes.charAt(ball)=='1') {
                    movesToMoveBallToBox+=Math.abs(box-ball);
                }
            }
            answer[box]=movesToMoveBallToBox;
        }

        return answer;
    }
}