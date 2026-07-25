/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> result = new ArrayList<>();
    List<List<Integer>> search = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        bfs(root, 0);
        for (List<Integer> s : search) {
            result.add(s.get(s.size()-1));
        }

        return result;
    }

    public List<Integer> bfs(TreeNode root, int level) {
        if (root == null) return null;
        if(search.size() <= level) {
            search.add(new ArrayList<>());
            search.get(level).add(root.val);
        } else {
            search.get(level).add(root.val);
        }
        bfs(root.left, level+1);
        bfs(root.right, level+1);
        return null;
    }
}
