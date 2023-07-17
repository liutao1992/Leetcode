package LeetCode.InvertBinaryTree;

import LeetCode.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }
}
