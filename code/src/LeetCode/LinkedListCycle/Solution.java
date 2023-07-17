package LeetCode.LinkedListCycle;

/**
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author liutao
 */
public class Solution {

    /**
     * Definition for singly-linked list.
     */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    public boolean hasCycle(ListNode head) {
          // 定义快慢指针，并初始化，将其指向head节点
          ListNode slow = head, fast = head;

          while (fast != null && fast.next != null) {
              // 慢指针走一步，快指针走两步
              slow = slow.next;
              fast = fast.next.next;

              // 若快慢指针相遇，则表明链表有环;反之则没有
              if (slow == fast) {
                  return true;
              }
          }
          return false;
    }
}
