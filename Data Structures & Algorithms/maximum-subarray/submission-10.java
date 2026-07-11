class Solution {
    public int maxSubArray(int[] nums) {
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
