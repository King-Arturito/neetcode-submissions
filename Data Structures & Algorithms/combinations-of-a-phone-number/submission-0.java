class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        Map<Character,String> digitMap = Map.of(
            '2', "abc",
            '3', "def",
            '4',"ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");
        
        dfs(0, digits, digitMap, new StringBuilder());
        return result;
    }

    public void dfs(int start, String digits,Map<Character,String> digitMap, StringBuilder sb) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : digitMap.get(digits.charAt(start)).toCharArray()) {
            sb.append(c);
            dfs(start+1, digits, digitMap, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
