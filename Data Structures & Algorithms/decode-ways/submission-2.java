class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            int curr = 0;

            if (oneDigit >= 1 && oneDigit <= 9) {
                curr += prev1;
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

