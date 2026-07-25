class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }


        int left = 0;
        int right = windowSize;
        while (right < s2.length()) {
            if (Arrays.equals(freq, freq2)) {
                return true;
            }
            freq2[s2.charAt(left) - 'a']--;
            left++;
            freq2[s2.charAt(right) - 'a']++;
            right++;
        }

        if (Arrays.equals(freq, freq2)) {
            return true;
        }

        return false;
    }
}
