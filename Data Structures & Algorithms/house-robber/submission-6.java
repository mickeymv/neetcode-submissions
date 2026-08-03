class Solution {
    public int rob(int[] monies) {
        int[] maxMoneyThatCanBeRobbed = new int[monies.length];

        maxMoneyThatCanBeRobbed[0]=monies[0];

        if(monies.length>1) {
            maxMoneyThatCanBeRobbed[1] = Math.max(monies[1], maxMoneyThatCanBeRobbed[0]);
        }


        for(int house=2;house<monies.length;house++) {
            maxMoneyThatCanBeRobbed[house] = Math.max(maxMoneyThatCanBeRobbed[house-1], monies[house]+maxMoneyThatCanBeRobbed[house-2]);
        }

        int max=0;

        for(int i=0;i<monies.length;i++) {
            max = Math.max(maxMoneyThatCanBeRobbed[i],max);
        }

        return max;
    }
}
