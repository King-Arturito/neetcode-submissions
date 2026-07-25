class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();


        for(int i = 0; i < times.length; i++) {
            adjList.computeIfAbsent(times[i][0],x -> new ArrayList<>()).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{k,0});
        HashMap<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            
            if (dist.containsKey(curr[0])) continue;
            dist.put(node, distance);
            if (adjList.containsKey(node)) {
                List<int[]> l =  adjList.get(node);
                for (int[] neighbor : l) {
                    int u = node;
                    int v = neighbor[0];
                    int w = neighbor[1];
                    pq.offer(new int[]{v, w+distance});
                }
            }
        }

        if (dist.size() != n) return -1;

        int time = 0;
        for (int currTime: dist.values()) {
            time = Math.max(time, currTime);
        }
        return time;
    }
}
