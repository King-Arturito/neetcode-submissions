class Solution {
    int substrings = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return substrings;
    }

    public void expand(String s, int prev, int next) {
        while (prev >= 0 && next < s.length()) {
            if  (s.charAt(prev) != s.charAt(next)) {
                break;
            }
            substrings += 1;
            prev--;
            next++;
        }
    }

    
}
