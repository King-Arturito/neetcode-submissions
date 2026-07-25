class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            int target = nums[i]*-1;
            while (j < k) {
                if (target != nums[j] + nums[k]) {
                    if (target > nums[j] + nums[k] && j < k) {
                        j++;
                    } else {
                        k--;
                    }
                } else {
                    List<Integer> l = List.of(nums[i], nums[j], nums[k]);
                    if (!result.contains(l)) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                    j++;
                }
            }
        }
        return result;
    }
}
//[-4, -1, -1, 0, 1, 2]

// 
