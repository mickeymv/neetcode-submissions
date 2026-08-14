class Solution {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1;

        int i=0;

        while(i<=r) {
            int num = nums[i];

            if (num==0) { //swap with left pointer
                nums[i]=nums[l];
                nums[l]=0;
                i++;
                l++;
                continue;
            }

            if (num==2) { //swap with right pointer
                nums[i] = nums[r];
                nums[r]=2;
                r--;
                continue;
            }

            if(num==1) {
                i++;
            }
        }
    }
}