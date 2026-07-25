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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = depth(root.left);
        }
        if (root.right != null) {
            right = depth(root.right);
        }
        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }
}
