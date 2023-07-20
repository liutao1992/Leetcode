package LeetCode.BinaryTreeLevelOrderTraversalii;

import LeetCode.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liutao
 */
public class Solution1 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }
}
