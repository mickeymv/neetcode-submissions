class Solution {
    public boolean isArraySpecial(int[] nums) {

        if(nums[0]%2==0) {
            //first element is even, so all even elements must be even
        for(int i=1;i<nums.length;i++) {
            if(i%2==0 && nums[i]%2!=0) {
                return false;
            }
            if(i%2!=0 && nums[i]%2==0) {
                return false;
            }
        }
        } else {
            for(int i=1;i<nums.length;i++) {
            if(i%2==0 && nums[i]%2==0) {
                return false;
            }
            if(i%2!=0 && nums[i]%2!=0) {
                return false;
            }
        }
        }


        return true;

    }
}