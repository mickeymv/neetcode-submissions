class Solution {
    public int coinChange(int[] coins, int amount) {
        int ways = minCoins(coins, 0, amount,0);

        if(ways==Integer.MAX_VALUE) {
            return -1;
        }

        return ways;
    }

    public int minCoins(int[] coins, int index, int amount, int noOfCoins) {
        if(amount==0) {
            return noOfCoins;
        }

        if(amount<0 || coins.length==index) {
            return Integer.MAX_VALUE;
        }

        int coinAmount = coins[index];

        return Math.min(minCoins(coins, index, amount-coinAmount, noOfCoins+1),
                        minCoins(coins, index+1, amount, noOfCoins));
    }
}
