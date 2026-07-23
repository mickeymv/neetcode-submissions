class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> complementToIndex = new HashMap<>();

        for(int i=0;i<nums.length;i++) {

            int complement = target - nums[i];

            if(complementToIndex.containsKey(complement)) {
                return new int[]{complementToIndex.get(complement), i};
            } else {
                complementToIndex.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
