package LeetCode.PartitionList;

import LeetCode.ListNode.ListNode.ListNode;

/**
 * 86.分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liutao
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        // 存储小于x的数据
        ListNode dummyHead1 = new ListNode();
        // 存储大于等于x数据
        ListNode dummyHead2 = new ListNode();
        ListNode p1 = dummyHead1, p2 = dummyHead2, p = head;

        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                // p2指针向后移动
                p2 = p2.next;
            }else {
                p1.next = p;
                // p1指针向后移动
                p1 = p1.next;
            }
            // 存储当前p节点next值，方便后序接着该节点继续遍历比较
            ListNode tmp = p.next;
            // 将当前p节点next指针置为空
            p.next = null;
            // 继续比较p后序节点
            p = tmp;
        }
        // 连接两个链表
        p1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
