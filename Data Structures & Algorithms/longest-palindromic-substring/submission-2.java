class Solution {
    String maxPalindrome = "";
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) { 
            findPalindrome(s,i,i);
            findPalindrome(s,i,i+1);
        }

        return maxPalindrome; 
    }

    public void findPalindrome(String s, int left, int right) {
        int maxLen = right - left;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        maxLen = right - left + 1;
        if (maxPalindrome.length() < maxLen) {
            maxPalindrome = s.substring(left, right+1);
        }
    }
}
