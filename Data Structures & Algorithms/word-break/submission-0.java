class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] subWordBreak = new boolean[s.length()+1];
        subWordBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (subWordBreak[j] && dict.contains(s.substring(j,i))) {
                    subWordBreak[i] = true;
                    break;
                }
            }
        }
        return subWordBreak[s.length()];
    }
}
