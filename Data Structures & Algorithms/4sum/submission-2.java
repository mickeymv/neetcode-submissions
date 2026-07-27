class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<String> quads = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    for(int l=k+1;l<nums.length;l++) {
                        String quad = nums[i]+""+nums[j]+""+nums[k]+""+nums[l];
                        long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum==target && !quads.contains(quad)) {
                            quads.add(quad);
                            results.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        }
                    }
                }
            }
        }

        return results;
    }
}