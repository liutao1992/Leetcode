package LiuBai.MaximumDepthOfNAryTree;

import java.util.List;

/**
 * 559:给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

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

    int depth = 0, res = 0;

    public int maxDepth(Node root) {
        traversal(root);
        return res;
    }

    void traversal(Node root) {
        if (root == null) {
            return;
        }
        depth ++;
        if (root.children.size() == 0) {
            res = Math.max(depth, res);
        }
        for (Node node:root.children) {
            traversal(node);
        }
        depth--;
    }
}
