package LiuBai.DeepestLeavesSum;

import LiuBai.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution1 {

    int maxLevel = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        traversal(root, 0);
        return sum;
    }

    private void traversal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        traversal(root.left, level + 1);
        traversal(root.right, level + 1);
    }
}
