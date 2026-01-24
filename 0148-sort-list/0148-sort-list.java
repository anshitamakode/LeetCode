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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return merge(first, second);
    }
    public ListNode merge(ListNode first, ListNode second){
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;
        while(first!=null && second!=null){
            if(first.val < second.val){
                temp.next = first;
                first = first.next;
                temp = temp.next;
            }
            else{
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
        }
        if(first!=null){
            temp.next = first;
        }
        if(second!=null){
            temp.next=second;
        }
        return dummy.next;
    }
}