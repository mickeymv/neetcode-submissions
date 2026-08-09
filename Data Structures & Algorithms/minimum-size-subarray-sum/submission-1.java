class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0;

        int minLen = 100001;
        int subSum = 0;
        
        while(left<=right && right<nums.length) {
            int num = nums[right];
            subSum+=num;
            if (subSum>=target) {
                while(subSum>=target) {
                    minLen = Math.min(minLen, right-left+1);
                    subSum-=nums[left];
                    left++;
                }
            } 
            right++;
        }

        return minLen == 100001 ? 0 : minLen;
    }
}