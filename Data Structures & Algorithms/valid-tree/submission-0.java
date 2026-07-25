class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            int rootA = unionFind(parent, edge[0]);
            int rootB = unionFind(parent, edge[1]);
            if (rootA == rootB) return false;
            parent[rootB] = rootA;
        }

        return true;
    }

    public int unionFind(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    } 
}


