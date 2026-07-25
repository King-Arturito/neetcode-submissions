class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int freq = buckets.length-1; freq >= 0 && index < k;freq--) {
            if (buckets[freq] != null) {
                for (int ind : buckets[freq]) {
                    result[index++] = ind;
                    if (index == k) break;
                }
            }
        }
        return result;
    }
}