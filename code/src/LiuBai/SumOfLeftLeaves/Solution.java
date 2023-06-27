package LiuBai.SumOfLeftLeaves;

/**
 * 404:左叶子之和：给定二叉树的根节点 root ，返回所有左叶子之和。
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

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root, false);
        return sum;
    }

    private void traversal(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        // 若遍历到叶子节点
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        traversal(root.left, true);
        traversal(root.right, false);
    }
}
