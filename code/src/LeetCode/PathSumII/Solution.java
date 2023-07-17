package LeetCode.PathSumII;

import java.util.LinkedList;
import java.util.List;

/**
 * 113:路径总和：给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
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

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum, path);
        return res;
    }

    int sum = 0;
    private void traversal(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        // 入栈
        sum += root.val;
        path.add(root.val);

        // 若当前是叶子节点,则判断sum与target是否相等
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new LinkedList<>(path));
            }
        }else {
            traversal(root.left, targetSum, path);
            traversal(root.right, targetSum, path);
        }
        // 出栈
        sum -= root.val;
        path.removeLast();
    }
}
