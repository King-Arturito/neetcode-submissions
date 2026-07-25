class PrefixTree {
    private Trie root;

    public static class Trie {
        Trie[] children;
        boolean isEnd;

        Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;

        for (char c: word.toCharArray())  {
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
