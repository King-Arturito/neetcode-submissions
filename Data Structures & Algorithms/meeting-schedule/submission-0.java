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
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(
            (a,b) -> a.start - b.start);

        for (int i = 0; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            minHeap.add(next);
        }

        while (minHeap.size() > 1) {
            Interval top = minHeap.poll();
            if (top.end > minHeap.peek().start) {
                return false;
            }
        } 
        return true;
    }
}
