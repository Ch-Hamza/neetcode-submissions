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
        return isSubTreeBalanced(root);
    }

    private boolean isSubTreeBalanced(TreeNode node) {
        if (node == null)
            return true;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // System.out.println(leftHeight);
        // System.out.println(rightHeight);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isSubTreeBalanced(node.left) && isSubTreeBalanced(node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
