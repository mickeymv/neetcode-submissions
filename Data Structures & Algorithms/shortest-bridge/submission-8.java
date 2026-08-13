class Solution {

    private int N;
    private boolean[][] visited;


    public int shortestBridge(int[][] grid) {
        N = grid.length;
        visited = new boolean[N][N];

        boolean islandFound = false;
        for(int r=0;r<N;r++) {
            if (islandFound) break;
            for(int c=0;c<N;c++) {
                if(grid[r][c]==1) {
                    visitIsland(grid,r,c);
                    islandFound= true;
                    break;
                }
            }
        }

        return shortestBridgeLen(grid);
    }

    private boolean isInvalid(int[][] grid, int r, int c) {
        return r<0 || c < 0 || r==N || c ==N || visited[r][c];
    }

    private void visitIsland(int[][] grid, int r, int c) {
        if (r<0 || c < 0 || r==N || c ==N || grid[r][c]==0 || visited[r][c]) {
            return;
        }

        visited[r][c]=true;

        visitIsland(grid,r+1,c);
        visitIsland(grid,r,c+1);
        visitIsland(grid,r-1,c);
        visitIsland(grid,r,c-1);
    }

    private int shortestBridgeLen(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for(int r=0;r<N;r++) {
            for(int c=0;c<N;c++) {
                if(visited[r][c]) {
                    queue.add(new int[]{r,c});
                }
            }
        }

        int bridgeLen = 0;

        while(!queue.isEmpty()) {
            for(int i=queue.size();i>0;i--) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                int curR=r+1,curC=c;

                if (!(isInvalid(grid, curR,curC))) {
                    if(grid[curR][curC]==1) return  bridgeLen;

                    queue.add(new int[]{curR, curC});
                    visited[curR][curC]=true;
                }

                curR=r;
                curC=c+1;

                                if (!(isInvalid(grid, curR,curC))) {
                    if(grid[curR][curC]==1) return  bridgeLen;

                    queue.add(new int[]{curR, curC});
                    visited[curR][curC]=true;
                }

                curR=r-1;
                curC=c;

                                if (!(isInvalid(grid, curR,curC))) {
                    if(grid[curR][curC]==1) return  bridgeLen;

                    queue.add(new int[]{curR, curC});
                    visited[curR][curC]=true;
                }

                curR=r;
                curC=c-1;

                                if (!(isInvalid(grid, curR,curC))) {
                    if(grid[curR][curC]==1) return  bridgeLen;

                    queue.add(new int[]{curR, curC});
                    visited[curR][curC]=true;
                }

            }
            bridgeLen++;
        }
        return bridgeLen;
    }
}