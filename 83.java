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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head.next;
        ListNode prev = head;
        while(node != null){
            if(node.val != prev.val){
                prev.next = node;
                prev = node;
            }
            node = node.next;
        }
        prev.next = null;
        return head;
    }
}
