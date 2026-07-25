class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(),0);
        return result;
    }

    public void backtrack(int[] candidates, int target, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            current.add(candidates[i]);
            backtrack(candidates, target-candidates[i], current,i+1);
            current.remove(current.size()-1);
        }
    }
}
