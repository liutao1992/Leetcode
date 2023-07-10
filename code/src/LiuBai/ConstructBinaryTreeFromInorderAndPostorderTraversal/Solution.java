package LiuBai.ConstructBinaryTreeFromInorderAndPostorderTraversal;

import LiuBai.TreeNode.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(postorder[postEnd]);

        // TODO 这里可以优化一下，每递归一次都需要遍历一次
        // 在中序遍历数组中找到根节点的索引
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        // 计算右子树的节点个数
        int rightSubTreeSize = inEnd - rootIndex;

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postEnd - rightSubTreeSize - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postEnd - 1);
        return root;
    }
}
