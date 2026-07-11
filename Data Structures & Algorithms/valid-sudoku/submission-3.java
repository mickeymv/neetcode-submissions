class Solution {
    public boolean isValidSudoku(char[][] board) {
        //every row, column, and subbox should have a set 
        //we need to ensure there are no duplicates in the set 
        //if there are duplicates, return false 
        //else after all checks, return true 
        
        //0 -> r=0-2, c=0-2 => r/3 + c/3 
        //1 -> r=0-2, c=3-5
        //2 -> r=0-2, c=6-8

        //3 -> r=3-5, c=0-2
        //4 -> r=3-5, c=3-5
        //5 -> r=3-5, c=6-8

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashMap<String, HashSet<Character>> boxKeyToSet = new HashMap<>();

        for(int i=0;i<9;i++) {
            rows[i] = new HashSet<>();
        }

        for(int i=0;i<9;i++) {
            cols[i] = new HashSet<>();
        }

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char num = board[r][c];
                if(num=='.') {
                    continue;
                }
                if(rows[r].contains(num)) {
                    return false;
                } else {
                    rows[r].add(num);
                }
                if(cols[c].contains(num)) {
                    return false;
                } else {
                    cols[c].add(num);
                }
                String boxKey = r/3+","+c/3;
                HashSet<Character> boxSet = boxKeyToSet.computeIfAbsent(boxKey, k-> new HashSet<>());
                if(boxSet.contains(num)) {
                    return false;
                } else {
                    boxSet.add(num);
                }
            }
        }  

        return true;

    }
}
