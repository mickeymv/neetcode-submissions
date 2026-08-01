class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];

        Arrays.fill(inc,1);
        Arrays.fill(dec,1);

        for(int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]) {
                inc[i]+=inc[i-1];
            } else if (nums[i]<nums[i-1]) {
                dec[i]+=dec[i-1];
            }
        }

        int max = 1;

        for(int i=1;i<nums.length;i++) {
            max = Math.max(max,dec[i]);
            max = Math.max(inc[i],max);
        }

        return max;
    }
}