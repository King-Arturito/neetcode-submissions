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
    int result = 0;
    int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        kth++;
        if (k == kth) {
            result = root.val;
            return;
        }

        inOrder(root.right, k);

    }
}
