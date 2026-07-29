class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for(int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0)+1);
        }

        for(int num: nums) {
            if(numToFreq.get(num)==1) {
                return num;
            }
        }

        return -1;
    }
}
