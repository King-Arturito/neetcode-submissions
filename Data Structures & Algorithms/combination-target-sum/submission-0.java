class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, new ArrayList<>(), 0);

        return result;
    }

    public void backtrack(int[] nums, int target, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            } 
            current.add(nums[i]);
            backtrack(nums, target - nums[i], current, i);
            current.remove(current.size()-1);
        }
    }
}