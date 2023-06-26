package LiuBai.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
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

    List<Integer> res = new ArrayList<>();


    /**
     * 中序遍历 左 -> 根 -> 右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }
}
