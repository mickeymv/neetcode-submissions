class Solution {
    public boolean check(int[] nums) {
        if(nums[0]<nums[nums.length-1]) {

            //only possible if the array is sorted 

            for(int i=0;i<nums.length-1;i++) {
                if(nums[i]>nums[i+1]) {
                    return false;
                }
            }


            return true;
            //^the last number is greater than first 
        } 
        
        //it has been rotated 

        if (nums[0]<nums[nums.length-1]) {
            return false;
            //the first number is less than last number 
            //which can't be true if rotated 
        }



        //ensure that it goes up, then down, then up again 

        int i=1;

        for(;i<nums.length;i++) {
            if(nums[i-1]>nums[i]) {
                break;
            }
        }

        //i is where it starts back 

        for(;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                return false;
            }
        }

        return true;
    }
}