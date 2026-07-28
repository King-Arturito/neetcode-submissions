class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int x = 0;

        for (int[] interval: intervals) {
            if (x > 0 && interval[0] <= result[x-1][1]) {
                result[x-1][1] = Math.max(interval[1], result[x-1][1]);
            } else {
                result[x++] = interval;
            }
        }

        //next = 5,8
        //prev = 1.5
        //should be = 1.8

        return Arrays.copyOf(result, x);
    }
}
