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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2, head = null, temp = null;
        int carry = 0;
        while(h1 != null && h2 != null){
            int sum = h1.val + h2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode node = new ListNode(sum, null);
            if(head == null){
                head = node;
                temp = node;
            }
            else{
                temp.next = node;
                temp = temp.next;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        while(h1 != null){
            int sum = h1.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode node = new ListNode(sum, null);
            temp.next = node;
            temp = temp.next;
            h1 = h1.next;
        }
        while(h2 != null){
            int sum = h2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode node = new ListNode(sum, null);
            temp.next = node;
            temp = temp.next;
            h2 = h2.next;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry, null);
            temp.next = node;
        }
        return head;
    }
}