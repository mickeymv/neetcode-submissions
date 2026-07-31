class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        Set<Integer> numsSet = new HashSet<>();

        for(int num : nums1) {
            nums1Set.add(num);
        }

        for(int num : nums2) {
            nums2Set.add(num);
        }

        for(int num : nums1Set) {
            if(nums2Set.contains(num)) {
                numsSet.add(num);
            }
        }

        int[] nums = new int[numsSet.size()];

        Iterator setIterator = numsSet.iterator();

        for(int i=0;i<numsSet.size();i++) {
            nums[i] = (int) setIterator.next();
        }

        return nums;
    }
}