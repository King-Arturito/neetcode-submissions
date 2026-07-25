class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        boolean[] visited = new boolean[points.length];
        int minCost = 0;

        //index, manhattan
        pq.offer(new int[]{0,0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int xi = points[curr[0]][0];
            int yi = points[curr[0]][1];

            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            minCost += curr[1];
            int currMin = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                int xj = points[i][0];
                int yj = points[i][1];
                int manhattan = Math.abs(xi - xj) + Math.abs(yi - yj);
                pq.offer(new int[]{i, manhattan});
            }
        }
        return minCost;
    }
}
    