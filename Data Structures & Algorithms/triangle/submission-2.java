class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int minPathSum = 0;
        int minIndex=0;

        List<Integer> firstRow = triangle.get(0);

        minPathSum+=firstRow.get(0);

        String key = 0+"-"+0;
        map.put(key, minPathSum);

        return minSumPath(triangle, 1, minIndex, minPathSum);
    }

    public int minSumPath(List<List<Integer>> triangle, int rowIndex, int prevIndex, int currentSum) {
        if(rowIndex==triangle.size()) {
            return currentSum;
        }

        String key = rowIndex+"-"+prevIndex;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        List<Integer> row = triangle.get(rowIndex);

        int thisIndexSum = minSumPath(triangle, rowIndex+1, prevIndex, currentSum+row.get(prevIndex));
        int nextIndexSum = minSumPath(triangle, rowIndex+1, prevIndex+1, currentSum+row.get(prevIndex+1));

        key = rowIndex+1+"-"+prevIndex;

        map.put(key, thisIndexSum);

        key = rowIndex+1+"-"+prevIndex+1;

        map.put(key, nextIndexSum);


        return Math.min(thisIndexSum,nextIndexSum);


    }
}