class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElementOfNums2 = new int[nums2.length];

        Arrays.fill(nextGreaterElementOfNums2, -1);

        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> nums2ToPos = new HashMap<>();

        for(int i=0;i<nums2.length;i++) {
            nums2ToPos.put(nums2[i],i);
        }

        for(int i=0;i<nums2.length;i++) {
            int number = nums2[i];

            while(!stack.isEmpty() && nums2[stack.peek()]<number) {
                //new number is greater, replace top of stack 
                int lowerNumberIndex = stack.pop();
                nextGreaterElementOfNums2[lowerNumberIndex] = number;
            }

            stack.push(i); 
        }

        int[] nums1Greater = new int[nums1.length];

        for(int i=0;i<nums1.length;i++) {
            int num = nums1[i];
            int indexInNums2 = nums2ToPos.get(num);
            nums1Greater[i] = nextGreaterElementOfNums2[indexInNums2];
        }

        return nums1Greater;
    }
}