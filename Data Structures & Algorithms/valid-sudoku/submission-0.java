class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<Integer>> rows = new HashMap<>();
        HashMap<Integer, List<Integer>> cols = new HashMap<>();
        HashMap<Integer, List<Integer>> squares = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            rows.putIfAbsent(i, new ArrayList<>());
            for (int j = 0; j < board[i].length; j++) {
                cols.putIfAbsent(j, new ArrayList<>());
                int square = (i/3) * 3 + (j/3);
                squares.putIfAbsent(square, new ArrayList<>());
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if  (rows.get(i).contains(val) 
                            || cols.get(j).contains(val)
                            || squares.get(square).contains(val)) {
                        return false;
                    } else  {
                        rows.get(i).add(val);
                        cols.get(j).add(val);
                        squares.get(square).add(val);
                    }
                }
            }
        }
        return true;
    }
}

