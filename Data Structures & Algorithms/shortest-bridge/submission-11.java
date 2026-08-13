class Solution {
    
    int N;
    boolean[][] visited;
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int shortestBridge(int[][] grid) {
        N = grid.length;
        visited = new boolean[N][N];

        boolean islandFound = false;
        for(int r=0;r<N;r++) {
            if (islandFound) break;
            for (int c=0;c<N;c++) {
                if(grid[r][c]==1) {
                    markIslandAsVisited(grid,r,c);
                    islandFound=true;
                    break;
                }
            }
        }    

        return shortestBridgeLen(grid);
    }

    private void markIslandAsVisited(int[][] grid, int r, int c) {
        if(c<0 || r<0 || r ==N || c==N || grid[r][c]==0 || visited[r][c]) {
            return;
        }

        visited[r][c]=true;

        for(int[] d : directions) {
            markIslandAsVisited(grid, r+d[0], c+d[1]);
        }
    }

    private int shortestBridgeLen(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int r=0;r<N;r++) {
            for (int c=0;c<N;c++) {
                if(visited[r][c]) {
                    q.add(new int[]{r,c});
                }
            }
        }   

        int bridgeLen=0;

        while(!q.isEmpty()) {
            for(int i=q.size();i>0;i--) {
                int[] cell = q.poll();
                int r=cell[0], c=cell[1];

                for(int[] d : directions) {
                    int rr = r+d[0], cc = c+d[1];

                    if(cc<0 || rr<0 || rr ==N || cc==N || visited[rr][cc]) {
                        continue;
                    }

                    if (grid[rr][cc]==1) return  bridgeLen; //reached the other island

                    visited[rr][cc]=true;
                    q.add(new int[]{rr,cc});
                }
            }
            bridgeLen++;
        }

        return bridgeLen;
    }
}