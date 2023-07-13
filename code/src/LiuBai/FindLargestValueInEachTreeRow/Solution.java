package LiuBai.FindLargestValueInEachTreeRow;

import LiuBai.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 * 示例1：
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 判断当前队列有多少节点
            int sz = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode curNode = queue.poll();
                maxValue = Math.max(maxValue, curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }


    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1,3,2,5,3, null,9};
        TreeNode root = TreeNode.createBinaryTree(nums);

        Solution solution = new Solution();
        List<Integer> list = solution.largestValues(root);

        for (Integer i:list) {
            System.out.println(i);
        }
    }
}
