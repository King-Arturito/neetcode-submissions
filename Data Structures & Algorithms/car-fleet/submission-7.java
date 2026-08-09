class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length];
        ArrayDeque<Double> st = new ArrayDeque<>();
        Integer[] ind = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            ind[i] = i;
        }
        Arrays.sort(ind, (a,b) -> position[b] - position[a]);

        for (int i = 0; i < position.length; i++) {
            double res = (target - position[ind[i]]) /(double) speed[ind[i]];
            time[i] = res;
            if (st.isEmpty() || st.peek() < time[i]) {
                st.push(time[i]);
            }
        }


        return st.size();
    }
}

