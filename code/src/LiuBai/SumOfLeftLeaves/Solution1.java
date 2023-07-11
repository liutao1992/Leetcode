package LiuBai.SumOfLeftLeaves;

import LiuBai.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution1 {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root, false);
        return sum;
    }

    void traversal(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == root.right && isLeft) {
            sum += root.val;
        }
        traversal(root.left, true);
        traversal(root.right, false);
    }
}
