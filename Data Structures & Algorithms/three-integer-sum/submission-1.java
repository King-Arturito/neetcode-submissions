class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (((-1) * nums[i]) == (nums[j] + nums[k])) {
                    List<Integer> l = List.of(nums[i], nums[j], nums[k]);
                    if (!result.contains(l)) {
                        result.add(l);
                    }   
                    j++;
                } else if (((-1) * nums[i]) > (nums[j] + nums[k])) {
                    j++;
                } else {
                    k--;
                }
                
            }
        }
        return result;
    }
}
