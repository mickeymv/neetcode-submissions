class Solution {
    public int coinChange(int[] coins, int amount) {
        int minCoins = minCoins(coins, 0, amount,0);

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int minCoins(int[] coins, int index, int target, int coinsUsed) {
        if(target==0) {
            return coinsUsed;
        }

        if(index==coins.length || target < 0) {
            return Integer.MAX_VALUE;
        }

        int coinAmount = coins[index];

        //we can either use the coin, or move past it 

        return Math.min(minCoins(coins, index, target-coinAmount,coinsUsed+1),
                        minCoins(coins, index+1, target, coinsUsed));
    }
}
