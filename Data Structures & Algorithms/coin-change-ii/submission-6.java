class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int change(int amount, int[] coins) {
        return change(amount,coins,0);
    }

    public int change(int amount, int[] coins, int index) {
        if(amount==0) {
            return 1; // found a combination
        }

        if(amount<0 || coins.length==index) {
            return 0;
        }

        String key = amount+"-"+index;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        int coinAmount = coins[index];
        
        map.put(key, change(amount-coinAmount,coins,index) + change(amount,coins,index+1));
        
        return map.get(key);

    }
}
