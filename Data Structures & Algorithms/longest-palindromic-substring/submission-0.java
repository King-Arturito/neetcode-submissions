class Solution {
    String longest = "";
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i+1);
        }
        return longest;
    }

    public void find(String s, int i, int j) {

        while (j < s.length() && i >= 0) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        if (longest.length() < s.substring(i+1,j).length()) {
            longest = s.substring(i+1, j);
        } 
    }
}
