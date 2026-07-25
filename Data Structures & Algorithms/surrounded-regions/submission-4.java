class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, visited, i, 0, m, n);

            if (board[i][n-1] == 'O') dfs(board, visited, i, n-1, m, n);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, visited, 0, j, m, n);
            if (board[m-1][j] == 'O') dfs(board, visited, m-1, j, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(char[][] board, boolean[][] visited,int i, int j, int m, int n) {
        visited[i][j] = true;
        int[][] dirs = new int[][]{{i+1,j}, {i-1,j}, {i,j+1}, {i,j-1}};
        for (int[] dir : dirs) {
            if (dir[0] < 0 || dir[0] >= board.length || dir[1] < 0 || dir[1] >= board[0].length || board[dir[0]][dir[1]] == 'X') continue; 

            if (visited[dir[0]][dir[1]]) continue; 
            if (board[dir[0]][dir[1]] == 'O') {
                dfs(board, visited, dir[0], dir[1], m, n);
            }
        }

    }
}
