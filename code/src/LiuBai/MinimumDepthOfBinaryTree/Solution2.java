package LiuBai.MinimumDepthOfBinaryTree;

import LiuBai.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution2 {

    public int minDepth(TreeNode root) {
        // 若根节点为空则返回0
        if (root == null) {
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        // 若左右节点其中一个为null，则返回不为空的孩子节点的深度
        if (root.left == null || root.right == null) {
            return minDepth(root.left) + minDepth(root.right) + 1;
        }
        minValue = Math.min(minDepth(root.left), minValue);
        minValue = Math.min(minDepth(root.right), minValue);
        return minValue + 1;
    }
}
