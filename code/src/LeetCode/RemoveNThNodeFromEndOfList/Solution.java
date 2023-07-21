package LeetCode.RemoveNThNodeFromEndOfList;

import LeetCode.ListNode.ListNode.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @author liutao
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummyHead, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummyHead.next;
    }

    /**
     * 返回链表的倒数第 k 个节点
     */
    ListNode findFromEnd(ListNode head, int k) {
        // 初始化p1、p2指针，指向头节点
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 指针先走n步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // 只要p1不为null，p1、p2指针就继续向前走
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
