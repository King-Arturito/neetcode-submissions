class Solution {
    public boolean canPartition(int[] nums) {
        int sum = findSum(nums);
        if (sum % 2 != 0) return false;

        boolean[] valid = new boolean[(sum/2)+1];
        valid[0] = true;

        for (int num : nums) {
            for (int i = sum/2; i >= num; i--) {
                if (valid[i - num] == true) {
                    valid[i] = true;
                }
            }
        }
        return valid[sum/2];
    }
    public int findSum(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }
}