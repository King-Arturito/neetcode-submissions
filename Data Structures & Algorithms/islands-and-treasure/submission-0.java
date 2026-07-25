class Solution {

    public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>(); 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.addLast(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!q.isEmpty()) {
            int[] loc = q.removeFirst();
            int i = loc[0];
            int j = loc[1];


            for (int[] dir : directions) {
                int landX = i + dir[0];
                int landY = j + dir[1];
                if (landX < 0 || landX >= grid.length || landY < 0 || landY >= grid[landX].length || grid[landX][landY] != 2147483647) {
                    continue;
                }
                grid[landX][landY] = grid[i][j] + 1;
                q.addLast(new int[]{landX,landY});
            }
        }

    }
}


//[0,2]
//[3,0]