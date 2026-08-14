class Solution {
    public int maxScore(int[] cards, int k) {
        int left=0,right=cards.length-k;

        int score=0;

        for(int i=right;i<cards.length;i++) {
            score+=cards[i];
        }

        int maxScore = score;

        while(right<cards.length) {
            score+=cards[left]-cards[right];

            maxScore = Math.max(maxScore,score);

            left++;
            right++;
        }

        return maxScore;
    }
}