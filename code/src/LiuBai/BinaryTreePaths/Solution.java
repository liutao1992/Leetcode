package LiuBai.BinaryTreePaths;

import LiuBai.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到
 * 叶子节点的路径。叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * @author liutao
 */
public class Solution {

    LinkedList<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == root.right) {
            path.add(root.val + "");
            // 将这条路径装入 res
            res.addLast(String.join("->", path));
            path.removeLast();
        }
        path.add(root.val + "");
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
}
