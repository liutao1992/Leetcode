package LiuBai.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liutao
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode createBinaryTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode currNode = queue.poll();

            if (nums[i] != null) {
                TreeNode leftNode = new TreeNode(nums[i]);
                currNode.left = leftNode;
                queue.offer(leftNode);
            }

            i++;

            if (i < nums.length && nums[i] != null) {
                TreeNode rightNode = new TreeNode(nums[i]);
                currNode.right = rightNode;
                queue.offer(rightNode);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        // 使用给定数组创建二叉树
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createBinaryTree(nums);
    }
}