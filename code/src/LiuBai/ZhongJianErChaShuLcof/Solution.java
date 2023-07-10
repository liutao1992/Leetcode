package LiuBai.ZhongJianErChaShuLcof;

import LiuBai.TreeNode.TreeNode;

import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * @author liutao
 */
public class Solution {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        // 构建根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 根据根节点获取获取中序遍历数组中对应索引值
        Integer rootIndex = valToIndex.get(root.val);

        // 计算左子树大小
        int leftSubTreeSize = rootIndex - inStart;
        root.left = buildHelper(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        root.right = buildHelper(preorder, inorder, preStart + leftSubTreeSize + 1, rootIndex + 1, inEnd);
        return root;
    }
}
