class Solution {
    public int minCostClimbingStairs(int[] cost) { 
        int first = 0;
        int second = 0;
        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(first + cost[i-1], second + cost[i-2]);
            second = first;
            first = temp;
        }

        return first;
    }
}
