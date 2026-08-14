class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0,right=cardPoints.length-k;

        int score=0;

        for(int i=right;i<cardPoints.length;i++) {
            score+=cardPoints[i];
        }

        int maxScore = score;

        while(right<cardPoints.length) {
            int leftCard = cardPoints[left];
            int rightCard = cardPoints[right];

            score = score+leftCard-rightCard;

            maxScore=Math.max(score, maxScore);
            left++;
            right++;
        }

        return maxScore;
    }
}