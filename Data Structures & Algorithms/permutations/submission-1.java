class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> current) {
        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, current);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
