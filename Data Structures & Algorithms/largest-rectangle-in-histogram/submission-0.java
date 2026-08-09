class Solution {
    public int largestRectangleArea(int[] heights) {
        int largest = 0;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int height = heights[st.pop()];

                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;

                largest = Math.max(largest, height * width);
            }

            st.push(i);
        }

        int n = heights.length;

        while (!st.isEmpty()) {
            int height = heights[st.pop()];

            int left = st.isEmpty() ? -1 : st.peek();
            int width = n - left - 1;

            largest = Math.max(largest, height * width);
        }

        return largest;
    }
}