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
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        invert(node);
        return root;     
    }

    private void invert(TreeNode node) {
        if (node == null)
            return;

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        if (node.left != null)
            invert(node.left);
        
        if (node.right != null)
            invert(node.right);
    }
}
