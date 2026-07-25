class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int min = 0;
        ArrayDeque<String> wordQueue = new ArrayDeque<>();
        wordQueue.addLast(beginWord);
        while (!wordQueue.isEmpty()) {
            min++;
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = wordQueue.removeFirst();
                wordList.remove(currentWord);
                for (String candidateWord : wordList) {
                    if (countDiff(currentWord,  candidateWord) == 1)  {
                        if (candidateWord.equals(endWord)) return min+1;
                        wordQueue.addLast(candidateWord);
                    }
                }
            }
        }       

        return 0;
    }

    public int countDiff(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count;
    }
}
