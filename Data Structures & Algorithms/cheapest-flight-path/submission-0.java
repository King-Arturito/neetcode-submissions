class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //[node, price, current k]
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> a.get(1) - b.get(1));
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v,w});
        }


        minHeap.offer(List.of(src, 0, 0));
        while (!minHeap.isEmpty()) {
            List<Integer> currNode = minHeap.poll();
            int node = currNode.get(0);
            int price = currNode.get(1);
            int pathLength = currNode.get(2);
            if (node == dst && pathLength <= k+1) {
                return price;
            }
            
            
            if (pathLength > k+1) continue;
            for (int[] neighbors : adj.getOrDefault(node, new ArrayList<>())) {
                minHeap.offer(List.of(neighbors[0], price+neighbors[1],pathLength+1));
            }
        }
        return -1;
    }
}
