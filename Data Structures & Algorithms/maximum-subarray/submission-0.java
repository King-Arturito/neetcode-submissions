class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int maxEnding = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            currMax = Math.max(maxEnding, currMax);
        }

        return currMax;
    }
}
