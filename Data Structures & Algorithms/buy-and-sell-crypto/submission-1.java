class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[left] > prices[i]) {
                left = i;
            }
            max = Math.max(max, prices[i] - prices[left]);
        }
        

        return max;
    }
}
