class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, n, m);
            dfs(heights, atlantic, i, m-1, n, m);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0,j,n, m);
            dfs(heights, atlantic,n-1,j,n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }


    public void dfs(int[][] heights, boolean[][] visited, int i, int j, int n, int m) {
        visited[i][j] = true;
        int[][] dirs = new int[][]{{i+1,j}, {i-1, j}, {i,j+1}, {i,j-1}};
        for (int[] dir : dirs) {
            if (dir[0] < 0 || dir[0] >= n || dir[1] < 0 || dir[1] >= m) {
                continue;
            }
            if (visited[dir[0]][dir[1]]) {
                continue;
            }

            if (heights[i][j] > heights[dir[0]][dir[1]]) continue;
            dfs(heights, visited, dir[0], dir[1], n, m);
        }
    }
}
