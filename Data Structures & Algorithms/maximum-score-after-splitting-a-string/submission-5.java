class Solution {
    public int maxScore(String s) {
        //00,11,01,10

        //0 1 1 1 0 1
        //0 1 2 3 4 5
        //1 1 1 1 2 2
        //4 4 3 2 1 1

        int[] maxScoreLeftForZeroes = new int[s.length()];
        int[] maxScoreRightForOnes = new int[s.length()];


        int noOfZeroesInLeftSubString=0;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)=='0') {
                noOfZeroesInLeftSubString++;  
            } 
            maxScoreLeftForZeroes[i]=noOfZeroesInLeftSubString;
        }

        int noOfOnesInRightSubString=0;

        for(int i=s.length()-1;i>0;i--) {
            if(s.charAt(i)=='1') {
                noOfOnesInRightSubString++;
            }
            maxScoreRightForOnes[i]=noOfOnesInRightSubString;
        }

        int maxScore=0;

        for(int split=0;split<s.length()-1;split++) {
            int score=maxScoreLeftForZeroes[split]+maxScoreRightForOnes[split+1];
            maxScore = Math.max(maxScore, score);
        }

        //01
        //zeroes: 11
        //ones:11

        return maxScore;
    }
}