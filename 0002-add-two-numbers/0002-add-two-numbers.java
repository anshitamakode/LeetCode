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
        ListNode l3 = new ListNode();
        ListNode head = l3;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int x = sum;
            if(sum > 9){
                carry = sum / 10;
                x = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode temp = new ListNode(x);
            l3.next = temp;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            int x = sum;
            if(sum > 9){
                carry = sum / 10;
                x = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode temp = new ListNode(x);
            l3.next = temp;
            l3 = l3.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            int x = sum;
            if(sum > 9){
                carry = sum / 10;
                x = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode temp = new ListNode(x);
            l3.next = temp;
            l3 = l3.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            l3.next = temp;
            l3 = l3.next;
        }
        return head.next;
    }
}