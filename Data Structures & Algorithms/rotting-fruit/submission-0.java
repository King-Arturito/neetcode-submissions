class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int minute = 0;
        Deque<int[]> rot = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)  {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rot.addLast(new int[]{i,j});
                }
            }
        }

        while (!rot.isEmpty() && fresh > 0) {
            minute++;
            int size = rot.size();

            for (int k = 0; k < size; k++) {
                int[] curr = rot.removeFirst();
                int i = curr[0];
                int j = curr[1];

                int[][] dirs = new int[][]{{i+1,j}, {i-1,j}, {i,j+1}, {i,j-1}};
                for (int[] dir : dirs) {
                    int ni = dir[0];
                    int nj = dir[1];
                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[ni].length || grid[ni][nj] != 1) {
                        continue;
                    }
                    grid[ni][nj] = 2;
                    fresh--;
                    rot.addLast(new int[]{ni, nj});
                }
            }
        }

        return fresh > 0 ? -1 : minute;
    }
}
