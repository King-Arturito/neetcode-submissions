/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n <= 1) return n;
        int minRooms = 1;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            start.add(intervals.get(i).start);
            end.add(intervals.get(i).end);
        }
        start.sort((a,b) -> a-b);
        end.sort((a,b) -> a-b);

        int left = 0;
        int right = 0;
        int max = 0;

        while (left < n && right < n) {
            if (start.get(left) < end.get(right)) {
                left++;
                max++;
                minRooms = Math.max(minRooms, max);
            } else {
                right++;
                max--;
            }
        }

        return Math.max(minRooms, max);
    }

}
