package LeetCode.MaximumLevelSumOfABinaryTree;

import LeetCode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1, maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelSum += cur.val;
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = depth;
            }
            depth ++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1,1,0,7,-8,-7,9};
        TreeNode root = TreeNode.createBinaryTree(nums);
        int levelSum = new Solution().maxLevelSum(root);
        System.out.println(levelSum);
    }
}
