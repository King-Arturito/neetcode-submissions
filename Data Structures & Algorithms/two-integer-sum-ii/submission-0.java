class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = 1;
        int currentSum = numbers[left] + numbers[right];
        while (currentSum != target) {
            if ((numbers[left] + numbers[right]) < target) {
                left++;
                right++;
            } else if((numbers[left] + numbers[right]) > target) {
                left--;
            } else {break;}
        }
        return new int[] {left+1, right+1};
    }
}

//[1,66, 72, 88] target = 154, 160
// currSum