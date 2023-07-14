package LiuBai.AverageOfLevelsInBinaryTree;

import LiuBai.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10-5 以内的答案可以被接受。
 * @author liutao
 */
public class Solution {

    List<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < sz; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(1.0 * sum / sz);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
