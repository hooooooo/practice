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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int size = 0;
        while(tail != null){
            size ++;
            if(tail.next != null){
              tail = tail.next;
            } else {
                break;
            }
        }
        
        if(tail == null){
            return tail;
        }
        
        k %= size;
        if(k == 0){
            return head;
        }
         
        k = size - k;
        
        ListNode prev = tail;
        ListNode current = head;
        ListNode next = head.next;
        prev.next = current;
        
        for(int i = 0; i<k; i++){
            prev = current;
            current = next;
            next = next.next;
        }
        
        // split
        prev.next = null;
        return current;
    }
}
