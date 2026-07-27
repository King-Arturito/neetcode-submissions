class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (backtrack(0, i, j, board, word) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(int start, int i, int j, char[][] board, String word) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 ||  j >= board[0].length) {
            return false;
        }

        if (board[i][j] == '!' || board[i][j] != word.charAt(start)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '!';

        boolean check = backtrack(start+1, i+1, j, board, word) 
        || backtrack(start+1, i-1, j, board, word) 
        || backtrack(start+1, i, j+1, board, word) 
        || backtrack(start+1, i, j-1, board, word);



        board[i][j] = temp;
        return check;
    }

}
