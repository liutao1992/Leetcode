package LeetCode.FindBottomLeftTreeValue;

import LeetCode.TreeNode.TreeNode;

/**
 * 采用深度优先策略
 * @author liutao
 */
public class Solution1 {
    int depth = 0;
    int maxDepth = 0;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        depth ++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root.val;
        }
        traversal(root.left);
        traversal(root.right);
        depth --;
    }
}
