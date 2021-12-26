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
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(t1 != null || t2 != null || carry > 0){
            int num = carry;
            if(t1 != null){
                num += t1.val;
                t1 = t1.next;
            }
            if(t2 != null){
                num += t2.val;
                t2 = t2.next;
            }
            ListNode v = new ListNode(num % 10);
            node.next = v;
            node = v;
            carry = num / 10;            
        }
        return dummy.next;
    }
}
