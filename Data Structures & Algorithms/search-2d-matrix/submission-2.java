class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        int midRow = 0;
        while (top <= bottom) {
            midRow = top + (bottom-top)/2;
            if (target > matrix[midRow][matrix[midRow].length-1]) {
                top = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                bottom = midRow - 1;
            } else {
                break;
            }
        }
        if (top > bottom) return false;

        int left = 0;
        int right = matrix[midRow].length-1;
        int midCol = 0;
        while (left <= right) {
            midCol = left + (right-left)/2;
            if (target == matrix[midRow][midCol]) {
                return true;
            } else if (target > matrix[midRow][midCol]) {
                left = midCol + 1;
            } else {
                right = midCol - 1;
            }
        }

        return false;
    }
}