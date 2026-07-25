class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxLeft = height[i];
        int maxRight = height[j];
        int maximum = 0;
        while (i < j) {
            if (maxLeft < maxRight) {
                maximum += Math.max(0, Math.min(maxLeft, maxRight) - height[i]);
                i++;
                maxLeft = Math.max(maxLeft, height[i]);
            } else {
                maximum += Math.max(0, Math.min(maxLeft, maxRight) - height[j]);
                j--;
                maxRight = Math.max(maxRight, height[j]);
            }
            
        }
        return maximum;
    }
}
