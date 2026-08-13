class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        return minPath(triangle, 0,0,0);
    }

    private int minPath(List<List<Integer>> triangle, int row, int index, int sum) {
        if (row==triangle.size()) {
            return sum;
        }

        List<Integer> curRow = triangle.get(row);
        int curElement = curRow.get(index);

        sum+=curElement;

        String key = row+"-"+index+"-"+sum;
        
        if(map.containsKey(key)) {
            return map.get(key);
        }

        map.put(key, Math.min(minPath(triangle, row+1,index,sum),
                        minPath(triangle, row+1,index+1,sum)));

        return map.get(key);
    }
}