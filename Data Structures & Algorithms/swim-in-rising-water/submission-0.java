class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int maxElev = 0;
        pq.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[grid.length][grid.length];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elev = curr[0];
            int x = curr[1];
            int y = curr[2];
            maxElev = Math.max(maxElev, elev);
            if ((x == grid.length-1) && (y == grid.length-1)) {
                return maxElev;
            }

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] dir : dirs) {
                int currX = x + dir[0];
                int currY = y + dir[1];
                if (currX < 0 || currX >= grid.length  || currY < 0 || currY >= grid.length) {
                    continue;
                }
                pq.offer(new int[]{grid[currX][currY], currX, currY});
            }
        }
        return -1;
    }
}
