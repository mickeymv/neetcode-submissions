class Solution {

    int ROWS,COLS;

    public int numIslands(char[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;
        
        int numOfIslands = 0;

        for(int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++) {
                if(grid[r][c]=='1') {
                    numOfIslands++;
                    markIslandAsSeen(grid,r,c);
                }
            }
        }

        return numOfIslands;
    }

    public void markIslandAsSeen(char[][] grid, int r, int c) {
        if(r>=ROWS||c>=COLS||c<0||r<0||grid[r][c]=='0') {
            return;
        }

        grid[r][c]='0';//mark as seen by making it water 

        markIslandAsSeen(grid,r+1,c);
        markIslandAsSeen(grid,r,c+1);
        markIslandAsSeen(grid,r-1,c);
        markIslandAsSeen(grid,r,c-1);
    }
}
