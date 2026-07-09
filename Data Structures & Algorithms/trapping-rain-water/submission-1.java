class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0]=0;//there's nothing to the left of the first height 
        maxRight[height.length-1]=0;//there's nothing to the right of the last height 

        for(int heightIndex = 1;heightIndex<height.length;heightIndex++) {
            maxLeft[heightIndex] = Math.max(maxLeft[heightIndex-1],height[heightIndex-1]);
        }

        for(int heightIndex = height.length-2;heightIndex>=0;heightIndex--) {
            maxRight[heightIndex] = Math.max(maxRight[heightIndex+1],height[heightIndex+1]);
        }

        int totalTrappedWater=0;

        for(int i=1;i<height.length-1;i++) {
            int heightOfWater = Math.min(maxLeft[i], maxRight[i]);
            int heightOfBlock = height[i];
            int trappedWater = heightOfWater-heightOfBlock;
            if(trappedWater>0) {
                totalTrappedWater+=trappedWater;
            }
        }

        return totalTrappedWater;
    }
}