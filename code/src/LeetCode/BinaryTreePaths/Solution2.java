package LeetCode.BinaryTreePaths;

import LeetCode.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 */
public class Solution2 {

    List<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        str.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(str.toString());
            str.deleteCharAt(str.length() - 1);
        }
        traversal(root.left);
        traversal(root.right);
        str.deleteCharAt(str.length() - 1);
    }
}
