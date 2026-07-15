class Solution {
    public boolean canPartition(int[] nums) {
        int sumOfNums =0;

        for(int num:nums) {
            sumOfNums+=num;
        }

        if(sumOfNums%2!=0){
            return false;
        }

        return canPartition(nums, 0, sumOfNums/2);
    }

    public boolean canPartition(int[] nums, int index, int sum) {
        if (sum==0) {
            return true;
        }

        if(sum<0 || index==nums.length) {
            return false;
        }

        return canPartition(nums, index+1, sum-nums[index]) || canPartition(nums, index+1, sum);
    }
}
