class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                result++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return result;
    }
}

//2,4,4,21,65,260   = end
//1,2,1,4, 5, 1     = start

//result = 0;
//ans = 3
//1->2
//1->4
//4->21
//5->65
//1->260