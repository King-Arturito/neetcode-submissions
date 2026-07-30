class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int unique = 1;
                if (i > 0 && j > 0) {
                    unique = dp[i-1][j] + dp[i][j-1];
                } else if (i == 0 && j == 0) dp[i][j] = 0;
                dp[i][j] = unique;
            }
        }
        return dp[m-1][n-1];
    }
}
