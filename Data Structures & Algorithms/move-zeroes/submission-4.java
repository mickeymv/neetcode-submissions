class Solution {
    public void moveZeroes(int[] nums) {
        int indexOfZeroToBeSwapped = -1;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                indexOfZeroToBeSwapped =i;
                break;
            }
        }

        if (indexOfZeroToBeSwapped==-1) {
            //no zeroes in the array 
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0 && indexOfZeroToBeSwapped<i) {
                //there is an earlier zero that can be swapped with this number 
                nums[indexOfZeroToBeSwapped]=nums[i];
                nums[i]=0;
                while(nums[indexOfZeroToBeSwapped]!=0) {
                    indexOfZeroToBeSwapped++;
                }
            }
        }
    }
}