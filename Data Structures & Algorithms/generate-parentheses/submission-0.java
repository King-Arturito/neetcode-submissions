class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,0,0,new StringBuilder());
        return result;
    }

    public void backtrack(int n, int open, int close, StringBuilder current) {
        if (current.length() == n*2) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append("(");
            backtrack(n, open+1,close,current);
            current.deleteCharAt(current.length()-1);
        }

        if (close < open) {
            current.append(")");
            backtrack(n, open, close+1, current);
            current.deleteCharAt(current.length()-1);
        }
    }
}


/*
(())
((
(
*/