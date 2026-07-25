class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int station = 0;
        int diff = 0;
        int tank = 0;
        int totalDiff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff = gas[i] - cost[i];
            tank += diff;
            totalDiff += diff;
            if (tank < 0) {
                station = i+1;
                tank = 0;
            }
            
        }
        return totalDiff >= 0 ? station : -1;   
    }
}
