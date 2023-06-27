package LiuBai.MaximumDepthOfBinaryTree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    /**
     * Definition for a binary tree node.
     */
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

    int res, deep;

    public int maxDepth(TreeNode root) {
       traverse(root);
       return res;
    }

    /**
     * 二叉树遍历框架==> 前序遍历:先访问节点自己，然后访问左子树，最后再访问右子树
     */
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        deep++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, deep);
        }
        traverse(root.left);
        traverse(root.right);
        deep--;
    }
}
