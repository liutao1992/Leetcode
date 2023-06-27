package LiuBai.PathSum;

/**
 * 112:给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hasPath;
    }

    int sum = 0;
    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        // 若当前节点为叶子节点，则判断Sum值
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                hasPath = true;
                return;
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right,targetSum);
        sum -= root.val;
    }
}
