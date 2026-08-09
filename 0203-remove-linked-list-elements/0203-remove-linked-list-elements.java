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
    public ListNode removeElements(ListNode head, int val) {
        
        
        while(head!=null&&head.val==val) head=head.next;
        if(head==null) return null;
        ListNode pre = head;
        ListNode temp = head.next;
        while(temp!=null){
            if(temp.val==val){
                pre.next=temp.next;
            }
            else{
                pre=temp;
            } 
            temp=temp.next;
        }
        return head;
    }
}