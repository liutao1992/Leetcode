package LeetCode.MergeTwoSortedLists;

import LeetCode.ListNode.ListNode.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @author liutao
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // 创建虚拟头节点
      ListNode dummyHead = new ListNode();

      ListNode p = dummyHead;

      ListNode p1 = list1, p2 = list2;

      // 同时遍历2个链表
      while (p1 != null && p2 != null) {
          // 比较2个链表的大小
          if (p1.val > p2.val) {
              p.next = p2;
              // p2 指针继续前进
              p2 = p2.next;
          }else {
              p.next = p1;
              // p1 指针继续前进
              p1 = p1.next;
          }
          // p指针继续前进
          p = p.next;
      }
      // 若p1没有到达链表尾部,则将后序合并到新的链表中
      if (p1 != null) {
        p.next = p1;
      }
      if (p2 != null) {
          p.next = p2;
      }
      return dummyHead.next;
    }
}
