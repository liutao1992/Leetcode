package LeetCode.ConstructBinaryTreeFromInorderAndPostorderTraversal;

import LeetCode.TreeNode.TreeNode;

import java.util.HashMap;

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
class Solution1 {

    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = valToIndex.get(root.val);
        // 计算右子树的节点个数
        int rightSubTreeSize = inEnd - rootIndex;
        // 递归构建左子树和右子树
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postEnd - rightSubTreeSize - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postEnd - 1);
        return root;
    }
}
