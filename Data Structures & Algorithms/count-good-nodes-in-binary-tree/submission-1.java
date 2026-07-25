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
    public int goodNodes(TreeNode root) {
        dfsMax(root, Integer.MIN_VALUE);
        return result;
    }

    public void dfsMax(TreeNode root, int max) {
        if (root == null) return;

        TreeNode temp = root;
        if (max <= temp.val) {
            result++;
        }
        int maxVal = Math.max(max, temp.val);
        dfsMax(temp.left, maxVal);
        dfsMax(temp.right,maxVal);  
    }
}