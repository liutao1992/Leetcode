package LeetCode.BinaryTreeLevelOrderTraversalii;

import LeetCode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author liutao
 */
public class Solution {

    List<List<Integer>> res = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return traversal(res, result);
    }

    private List<List<Integer>> traversal(List<List<Integer>> e, List<List<Integer>> result) {
        for (int i = e.size() - 1; i >= 0; i--) {
            List<Integer> el = e.get(i);
            result.add(el);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createBinaryTree(nums);

        Solution solution = new Solution();

        List<List<Integer>> lists = solution.levelOrderBottom(root);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
