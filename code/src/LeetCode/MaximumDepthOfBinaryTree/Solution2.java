package LeetCode.MaximumDepthOfBinaryTree;

import LeetCode.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution2 {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return 0;
        }
        maxDepth = Math.max(maxDepth(root.left), maxDepth);
        maxDepth = Math.max(maxDepth(root.right), maxDepth);
        return maxDepth + 1;
    }
}
