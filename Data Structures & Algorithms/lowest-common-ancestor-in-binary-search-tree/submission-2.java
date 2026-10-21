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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
        // return isAncestor(root, p, q);
    }

    private TreeNode isAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || (node.left == null && node.right == null))
            return null;

        if (isAncestor(node.left, p, q) != null)
            return node.left;
        if (isAncestor(node.right, p, q) != null)
            return node.right;

        if (hasDescendant(node, p) && hasDescendant(node, q))
            return node;

        return null;
    }

    private boolean hasDescendant(TreeNode node, TreeNode x) {
        if (node == null)
            return false;
        if (node.val == x.val)
            return true;

        return hasDescendant(node.left, x) || hasDescendant(node.right, x);
    }
}
