package LeetCode.FindBottomLeftTreeValue;

import LeetCode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 * @author liutao
 */
public class Solution {

    /**
     * 采用广度优先解法
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 在遍历一个节点时，需要先把它的非空右子节点放入队列，然后再把它的非空左子节点放入队列，
                // 这样才能保证从右到左遍历每一层的节点。
                // 广度优先搜索所遍历的最后一个节点的值就是最底层最左边节点的值。
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                res = cur.val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeNode.createBinaryTree(nums);
        System.out.println(new Solution().findBottomLeftValue(root));
    }
}
