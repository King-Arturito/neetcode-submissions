class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(String s, int start,List<String> p) {
        if (start == s.length()) {
            result.add(new ArrayList<>(p));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                p.add(s.substring(start,end+1));
                backtrack(s, end+1, p);
                p.remove(p.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}