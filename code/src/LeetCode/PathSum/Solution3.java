package LeetCode.PathSum;

import LeetCode.TreeNode.TreeNode;

/**
 * @author liutao
 */
public class Solution3 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == root.right && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left,targetSum - root.val)
                || hasPathSum(root.right,targetSum - root.val);
    }
}
