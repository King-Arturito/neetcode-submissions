class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited = new boolean[points.length];
        int[] minDist = new int[points.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int minCost = 0;

        for (int i = 0; i < points.length; i++) {
            int u = -1;

            for (int j = 0; j < points.length; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            minCost += minDist[u];

            for (int k = 0; k < points.length; k++) {
                if (!visited[k]) {
                    int manhattan = Math.abs(points[u][0] - points[k][0]) + Math.abs(points[u][1] - points[k][1]);
                    if (manhattan < minDist[k]) {
                        minDist[k] = manhattan;
                    }
                }
                
            }
        }
        return minCost;
    }
}
