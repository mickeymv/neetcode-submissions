class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0,right=0;

        while(right<nums.length) {
            int num = nums[right];

            //go to the end of occurences for num 
            int occurences = 0;
            while(right<nums.length && nums[right]==num) {
                right++;
                occurences++;
            }

            //right is at the end , we need to move the 
            //two values 
            nums[left] = num;
            left++;

            if(occurences>1) {
                nums[left] = num;
                left++;
            } 
        }

        return left;
    }
}