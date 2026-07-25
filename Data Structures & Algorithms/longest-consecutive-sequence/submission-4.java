class Solution {
    public int longestConsecutive(int[] nums) {
        if  (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> consecutives = new TreeSet<>();
        int cons = 1;
        int curr = 1;
        int most = 1;
        for (int i = 0; i < nums.length; i++) {
            consecutives.add(nums[i]);
        }
        curr = consecutives.pollFirst();
        while (true) {
            if (consecutives.size() == 0) break;
            int next = consecutives.pollFirst();
            if ((curr+1) == next) {
                cons += 1;
                if (most < cons) {most = cons;}
            } else {
                cons = 1;
            }
            curr = next;
        }
        return most;
    }
}