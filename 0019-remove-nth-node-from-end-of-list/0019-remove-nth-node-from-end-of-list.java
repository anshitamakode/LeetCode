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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1)
            return null;      
        ListNode first = head, second = head;
        int cnt = n;
        while(second != null && cnt > 0){
            second = second.next;
            cnt--;
        }
        if(second == null){
            return head.next;
        }
        while(second != null && second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}