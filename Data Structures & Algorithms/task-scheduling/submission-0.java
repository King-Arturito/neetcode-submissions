class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];

        for (char task : tasks) {
            int index = task - 'A';
            freqs[index]++;
        }

        int maxNum = 0;
        int currMax = 0;

        for (int freq : freqs) {
            if (freq > currMax) {
                maxNum = 1;
                currMax = freq;
            } else if (freq == currMax) {
                maxNum++;
            }
        }

        int time = maxNum + (currMax - 1) * (n + 1);
        return Math.max(time, tasks.length);
    }
}


