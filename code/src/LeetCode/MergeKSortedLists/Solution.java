package LeetCode.MergeKSortedLists;

import LeetCode.ListNode.ListNode.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode();
        // 初始指针，将其指向头节点
        ListNode p = dummy;
        // 使用最小堆动态排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length, (a, b)-> (a.val - b.val)
        );
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head:lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        while (!queue.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
