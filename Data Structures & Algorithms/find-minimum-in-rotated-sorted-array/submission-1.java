class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right-left)/2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[right] == nums[middle]) {
                return nums[middle];
            } else {
                right = middle;
            }
        }
        return nums[middle];
    }
}
