class Solution {
    public int maxSubArray(int[] nums) {
        //one problem that I have with this question 
        //is that I don't know what the recurrence relationship is 
        /*
        how do i think about the dp array? 
        I can think about the maxSubArrayUntil a particular index 
        but I'll need another indication of where the subArray even started from 

        I can't be greedy and use a sliding window, because the local optimum might not 
        lead to a global maximum 
        */

        int maxSubArray = nums[0];

        int[] currentBest = new int[nums.length];

        currentBest[0] = nums[0];

        for(int i=1;i<nums.length;i++) {
            currentBest[i] = Math.max(currentBest[i-1]+nums[i],nums[i]);
            maxSubArray = Math.max(maxSubArray, currentBest[i]);
        }

        return maxSubArray;
    }
}
