package LiuBai.NAryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 589:给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    /**
     * Definition for a Node.
     */
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        traversal(root);
        return res;
    }

    private void traversal(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node: root.children) {
            traversal(node);
        }
    }
}
