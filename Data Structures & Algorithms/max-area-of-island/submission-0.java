class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid,i,j,0),max);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int i, int j, int curr) {
        if (i < 0 || i >= grid.length
            || j < 0 || j >= grid[i].length || grid[i][j] ==  0) {
            return curr;
        }
        curr += 1;

        grid[i][j] = 0;

        curr = dfs(grid, i-1, j, curr);
        curr = dfs(grid, i+1, j, curr);
        curr = dfs(grid, i, j-1, curr);
        curr = dfs(grid, i, j+1, curr);

        return curr;
    }
}
