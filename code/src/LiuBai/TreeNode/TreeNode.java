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
        // 创建根节点
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curNode = queue.poll();
            if (nums[i] != null) {
                curNode.left = new TreeNode(nums[i]);
                queue.offer(curNode.left);
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                curNode.right = new TreeNode(nums[i]);
                queue.offer(curNode.right);
            }
            i++;
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // 使用给定数组创建二叉树
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createBinaryTree(nums);
        TreeNode.preOrder(root);
    }
}