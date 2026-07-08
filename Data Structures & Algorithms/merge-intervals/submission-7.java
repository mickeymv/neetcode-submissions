class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //^ this sorts the intervals based on start time 

        int[] firstInterval = intervals[0];

        List<int[]> nonOverlappingIntervals = new ArrayList<>();

        for(int i=1;i<intervals.length;i++) {
            int[] currentInterval = intervals[i];
            if(firstInterval[1]>=currentInterval[0]) {
                //first's endTime >= this' endTime 
                //there is overlap, so merge them
                firstInterval[1]=Math.max(currentInterval[1],firstInterval[1]);
                //^setting the endTime of first as that of the current  
            } else {
                //no overlap 
                nonOverlappingIntervals.add(firstInterval);
                firstInterval = currentInterval;
            }
        }

        nonOverlappingIntervals.add(firstInterval);


        int[][] res = new int[nonOverlappingIntervals.size()][2];

        for(int i=0;i<nonOverlappingIntervals.size();i++) {
            res[i]=nonOverlappingIntervals.get(i);
        }

        return res;
    }
}
