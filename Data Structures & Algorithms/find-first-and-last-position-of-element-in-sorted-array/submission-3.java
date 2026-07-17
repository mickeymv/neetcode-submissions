class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1,end=-1;

        boolean startFound = false;

        if(nums.length==0) {
            return new int[]{start,end};
        }

        int left=0,right=nums.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                while(mid >=0 && nums[mid]==target) {
                    start=mid;
                    mid--;
                }
                mid++;
                while(mid<=nums.length-1 && nums[mid]==target) {
                    end=mid;
                    mid++;
                }
                break;
            } else if (nums[mid]>target) {
                right = mid-1;
            } else {
                left=mid+1;
            }
        }

        return new int[]{start,end};
    }
}