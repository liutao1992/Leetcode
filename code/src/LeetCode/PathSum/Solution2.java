package LeetCode.PathSum;

import LeetCode.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution2 {

    int sum = 0;
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum);
        return hasPath;
    }

    private void traversal(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == root.right && targetSum == sum) {
            hasPath = true;
            return;
        }
        traversal(root.left, targetSum);
        traversal(root.right, targetSum);
        sum -= root.val;
    }
}
