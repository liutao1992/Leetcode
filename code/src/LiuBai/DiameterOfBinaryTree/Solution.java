package LiuBai.DiameterOfBinaryTree;

/**
 * 给你一棵二叉树的根节点，返回该树的直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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

    int res = 0;
    int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        height++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, height);
        }
        traversal(root.left);
        traversal(root.right);
        height--;
    }

}
