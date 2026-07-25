class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
