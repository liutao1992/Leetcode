package LiuBai.SymmetricTree;

import LiuBai.TreeNode.TreeNode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author liutao
 */
public class Solution {

    LinkedList<Integer> res = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == r2) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}
