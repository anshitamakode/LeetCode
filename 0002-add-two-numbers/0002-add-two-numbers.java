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
        int sum = 0, carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int curr = sum % 10;
            ListNode newNode = new ListNode(curr);
            temp.next = newNode;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = l1.val + carry;
            carry = sum / 10;
            int curr = sum % 10;
            ListNode newNode = new ListNode(curr);
            temp.next = newNode;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2 != null){
            sum = l2.val + carry;
            carry = sum / 10;
            int curr = sum % 10;
            ListNode newNode = new ListNode(curr);
            temp.next = newNode;
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }
        return ans.next;
    }
}