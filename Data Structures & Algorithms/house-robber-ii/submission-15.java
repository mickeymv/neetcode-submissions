class Solution {
    public int rob(int[] money) {
        if(money.length==1) {
            return money[0];
        } 

        return Math.max(helper(Arrays.copyOfRange(money, 0, money.length-1)),
                        helper(Arrays.copyOfRange(money, 1, money.length)));
    }

    private int helper(int[] money) {
        if(money.length==1) {
            return money[0];
        }

        int[] maxRob = new int[money.length];

        maxRob[0] = money[0];
        if(money.length>1) {
            maxRob[1] = Math.max(money[1], maxRob[0]);
        }

        for(int house = 2; house< money.length;house++) {
            maxRob[house] = Math.max(maxRob[house-1], maxRob[house-2]+money[house]);
        }

        return maxRob[money.length-1];
    }
}
