package LiuBai.ConstructStringFromBinaryTree;

import LiuBai.TreeNode.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 *
 * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        // 递归生成左右子树的字符串
        String leftStr = tree2str(root.left);
        String rightStr = tree2str(root.right);

        // 后序遍历代码位置
        // 根据左右子树字符串组装出前序遍历的顺序
        // 按题目要求处理 root 只有一边有子树的情况
        if (root.left != null && root.right == null) {
            // 省略空的右子树
            return root.val + "(" + leftStr + ")";
        }
        if (root.left == null && root.right != null) {
            // 空的左子树不能省略
            return root.val + "()" + "(" + rightStr + ")";
        }
        return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
    }
}
