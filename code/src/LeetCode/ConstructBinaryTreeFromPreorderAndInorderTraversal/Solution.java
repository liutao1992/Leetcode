package LeetCode.ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @author liutao
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     * 是一个递归辅助函数，它接受以下参数：
     * @param preorder 先序遍历数组
     * @param inorder  中序遍历数组
     * @param preStart 当前子树在先序遍历数组中的起始索引
     * @param inStart  当前子树在中序遍历数组中的起始索引
     * @param inEnd    当前子树在中序遍历数组中的结束索引
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        // 首先，检查先序遍历和中序遍历的数组是否为空。如果为空，则返回 null。
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 在中序遍历数组中找到根节点的索引
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        // 计算左子树的节点个数 ==> 1 - 0
        int leftSubTreeSize = rootIndex - inStart;

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(preorder, inorder,
                preStart + 1, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, inorder,
                preStart + leftSubTreeSize + 1, rootIndex + 1, inEnd);
        return root;
    }
}
