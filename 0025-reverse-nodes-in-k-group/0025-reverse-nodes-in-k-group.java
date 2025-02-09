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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, knode = null, prev = null, next = null;
        while(temp != null){
            knode = findKNode(temp, k);
            if(knode == null){
                if(prev != null)
                    prev.next = temp;
                break;
            }
            else{
                next = knode.next;
                knode.next = null;
                reverseGroup(temp);
                if(temp == head){
                    head = knode;
                }
                else{
                    prev.next = knode;
                }
                prev = temp;
                temp = next;
            }
        }
        return head;
    }
    public ListNode findKNode(ListNode head, int k){
        ListNode temp = head;
        while(temp != null && k > 1){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public void reverseGroup(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}