class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums,int i, List<Integer> curr) {
        result.add(new ArrayList<>(curr));

        while (i < nums.length) {
            curr.add(nums[i]);
            backtrack(nums, i+1, curr);
            curr.remove(curr.size()-1);
            i++;
        }
    }
}
