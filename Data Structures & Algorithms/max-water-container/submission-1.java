class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int maximum = 0;
        int j = heights.length-1;
        while (i < j) {
            if (heights[i] < 1) i++;
            if (heights[j] < 1) j--;
            maximum = Math.max(Math.min(heights[i], heights[j]) * (j - i), maximum);
            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maximum;
    }
}
