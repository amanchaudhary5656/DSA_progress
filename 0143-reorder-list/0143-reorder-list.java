/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode first = head;
        ListNode slow = head, fast= head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp  =slow.next;
        ListNode prev = null;
        slow.next = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        ListNode second = prev;
        while(second != null){
            ListNode a = first.next;
            ListNode b = second.next;
            first.next = second;
            second.next = a;
            first =a;
            second  = b;
        }
      

    }
}