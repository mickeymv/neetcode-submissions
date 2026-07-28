class Solution {

    public int coinChange(int[] coins, int amount) {

        int minCoins = minCoins(coins, 0, amount, 0);

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int minCoins(int[] coins, int index, int amount, int noOfCoins) {
        if(index==coins.length && amount==0) {
            return noOfCoins;
        }

        if(amount<0 || index==coins.length) {
            return Integer.MAX_VALUE;
        }



        int coinAmount = coins[index];

        //we can either use the coin, or not use it 

        int minCoins = Math.min(minCoins(coins, index, amount-coinAmount, noOfCoins+1),
                            minCoins(coins,index+1, amount, noOfCoins));
        
        return minCoins;
    }
}
