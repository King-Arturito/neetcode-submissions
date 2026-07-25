class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] rep = new int[n];
        int count = n;
        for (int i = 0; i < n; i++)  {
            rep[i] = i;
        }

        for (int[] edge : edges) {
            int rootA = unionFind(rep, edge[0]);
            int rootB = unionFind(rep, edge[1]);

            if (rootA != rootB) count--;
            rep[rootB] = rootA;
            
        }
        return count;
    }

    public int unionFind(int[] rep, int x) {
        while (rep[x] != x) {
            rep[x] = rep[rep[x]];
            x = rep[x];
        }

        return x;
    }
}
