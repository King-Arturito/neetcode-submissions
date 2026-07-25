class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int k = 1;
        int totalHours = 0;

        while (k <= max) {
            totalHours = 0;
            int middle = k + (max-k)/2;
            for (int pile : piles) {
                totalHours += Math.ceil((double)pile/(double)middle);
            }
            if (totalHours <= h) {
                max = middle - 1;
            } else {
                k = middle + 1;
            }
        }
        return k;
    }
}
