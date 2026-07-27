class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> sub) {
        result.add(new ArrayList<>(sub));

        for (int i = start; i < nums.length; i++) {

            sub.add(nums[i]);
            backtrack(nums, i+1, sub);
            sub.remove(sub.size()-1);
        }
    }
}
