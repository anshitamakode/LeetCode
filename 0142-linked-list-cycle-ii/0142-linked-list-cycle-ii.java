/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(slow == null || slow.next == null)
            return null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        slow = head;
        while(slow != null && fast != null){
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}