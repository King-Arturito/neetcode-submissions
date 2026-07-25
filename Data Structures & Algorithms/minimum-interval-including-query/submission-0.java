class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        List<List<Integer>> lengths = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][1] - intervals[i][0] + 1;
            lengths.add(new ArrayList<>(List.of(l,i)));
        }
        lengths.sort((a,b) -> a.get(0) - b.get(0));
        System.out.println(lengths.toString());

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int j = 0; j < intervals.length; j++) {
                int intervalIndex = lengths.get(j).get(1);
                int length = lengths.get(j).get(0);
                if (q <= intervals[intervalIndex][1] && q >= intervals[intervalIndex][0]) {
                    result[i] = length;
                    break;
                }
            }
            if (result[i] == 0) {
                result[i] = -1;
            }
        }
        return result;
    }
}
