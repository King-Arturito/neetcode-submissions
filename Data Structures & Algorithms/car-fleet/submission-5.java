class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        int[] sortedPos   = new int[position.length];
        int[] sortedSpeed = new int[speed.length];
        for (int i = 0; i < indices.length; i++) {
            sortedPos[i]   = position[indices[i]];
            sortedSpeed[i] = speed[indices[i]];
        }

        Deque<Double> st = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - sortedPos[i]) / sortedSpeed[i];
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);   // new fleet
            }
            // else: time <= peek, car catches up → same fleet, do nothing
        }

        return st.size();
    }
}