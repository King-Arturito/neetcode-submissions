class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->a[0]-b[0]);
        List<List<Integer>> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        result.add(new ArrayList<>(List.of(start,end)));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                result.remove(result.size()-1);
                result.add(new ArrayList<>(List.of(start,end)));
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
                result.add(new ArrayList<>(List.of(start,end)));
            }
        }
        int[][] finalResult = result
            .stream()
            .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
        return finalResult;
    }
}
