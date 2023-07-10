package LiuBai.ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import LiuBai.TreeNode.TreeNode;

import java.util.HashMap;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，
 * postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *
 * 如果存在多个答案，您可以返回其中 任何 一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return buildHelper(preorder, postorder, 0, 0, postorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int[] postorder, int preStart, int postStart, int postEnd) {
        if (preStart > preorder.length - 1 || postStart > postEnd) {
            return null;
        }
        if (preStart == preorder.length - 1) {
            return new TreeNode(preorder[preStart]);
        }

        // 构造根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 查找左右子树边界对应的索引值
        int leftLastIndex = valToIndex.get(preorder[preStart + 1]);

        // 获取左子树的大小
        int leftSubTreeSize = leftLastIndex - postStart + 1;

        root.left = buildHelper(preorder, postorder, preStart + 1, postStart, leftLastIndex);
        root.right = buildHelper(preorder, postorder, preStart + leftSubTreeSize + 1, leftLastIndex + 1, postEnd - 1);
        return root;
    }
}
