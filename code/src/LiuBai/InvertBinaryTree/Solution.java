package LiuBai.InvertBinaryTree;

/**
 * 226：翻转二叉树 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @author liutao
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        root.left = right;
//        root.right = left;
//
//        traversal(root.left);
//        traversal(root.right);

        // 定义一个中间变量
        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

        traversal(root.left);
        traversal(root.right);
    }

}
