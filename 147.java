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
 
    // need to track head and tail
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode next = head.next;
        head.next = null;
        
        while(next != null){
            ListNode current = next;
            next = next.next;
            
            // search for a proper location
            ListNode location = dummy;
            while(location.next != null && location.next.val < current.val){
                location = location.next;
            }
            
            ListNode tempNext = location.next;
            location.next = current;
            current.next = tempNext;     
        }
        return dummy.next;
    }
}
