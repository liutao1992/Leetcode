package LeetCode.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 145：给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
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

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        traversal(root.right);
        res.add(root.val);
    }
}
