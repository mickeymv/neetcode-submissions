class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=0;

        Map<Integer,Integer> prefixSumToCount = new HashMap<>();

        prefixSumToCount.put(0, 1); //base case, since there is one of zero sum

        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            int prefixSum = sum-k;

            if (prefixSumToCount.containsKey(prefixSum)) {
                n+=prefixSumToCount.get(prefixSum);
            } 

            prefixSumToCount.put(sum, prefixSumToCount.getOrDefault(sum, 0)+1);
        }

        return n;
    }
}