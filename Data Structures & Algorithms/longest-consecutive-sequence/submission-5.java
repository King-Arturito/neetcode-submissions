class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if (!set.contains(num-1)) {
                int curr = num;
                int cons = 1;
                while (set.contains(curr+1)) {
                    cons++;
                    curr++;
                }
                max = Math.max(cons, max);
            }
        }

        return max;
    }
}
