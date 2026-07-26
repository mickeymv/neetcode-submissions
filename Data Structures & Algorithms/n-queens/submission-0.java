class Solution {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiags = new HashSet<>(); //r+c 
    Set<Integer> negDiags = new HashSet<>(); //r-c 

    List<List<String>> results = new ArrayList<>();
    char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0);

        return results;
    }

    private void backtrack(int r) {
        if(r==n) {
            List<String> result = new ArrayList<>();
            for(char[] row : board) {
                result.add(new String(row));
            }
            results.add(result);
        }
        
        for(int c=0;c<n;c++){
            if(cols.contains(c) 
            || posDiags.contains(r+c)
            || negDiags.contains(r-c)) {
                continue;
            }
            cols.add(c);
            posDiags.add(r+c);
            negDiags.add(r-c);
            board[r][c]='Q';

            backtrack(r+1);

            cols.remove(c);
            posDiags.remove(r+c);
            negDiags.remove(r-c);  
            board[r][c]='.';          
        }


    }
}
