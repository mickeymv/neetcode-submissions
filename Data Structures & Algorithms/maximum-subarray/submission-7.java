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

        int maxSubArray = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            int currentSubArraySum=0;
            for(int j=i;j<nums.length;j++) {
                currentSubArraySum+=nums[j];
                maxSubArray = Math.max(currentSubArraySum,maxSubArray);
            }
        }

        return maxSubArray;
    }
}
