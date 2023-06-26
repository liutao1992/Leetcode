package LiuBai.MinimumDepthOfBinaryTree;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 说明：叶子节点是指没有子节点的节点。
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

    int deep = 0, res = 0;
    public int minDepth(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        deep++;
        if (root.left == null && root.right == null) {
            res = Math.min(deep, res);
        }
        traversal(root.left);
        traversal(root.right);
        deep--;
    }
}
