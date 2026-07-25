class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        while (right < s.length()) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                right++;
                max = Math.max(max, charSet.size());
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
