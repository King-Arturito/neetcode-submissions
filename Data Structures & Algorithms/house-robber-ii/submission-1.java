class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(houseRob(nums, 0, nums.length-2), houseRob(nums, 1, nums.length-1));
    }

    public int houseRob(int[] nums, int start, int end) {
        int first = 0;
        int second = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(second, first + nums[i]);
            first = second;
            second = curr;
        }
        return second;
    }
}
