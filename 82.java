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
        ListNode dummy = new ListNode(200);
        dummy.next = head;
        
        ListNode prev = null;
        ListNode last = null;
        
        ListNode dupStart = null;
        ListNode dupPrev = null;
        
        ListNode node = dummy;
        while(node != null && (prev == null || last == null)){
            if(prev == null){
                prev = node;
            } else if(last == null){
                last = node;
            }
            node = node.next;
        }
        
        while(node != null){
            if(dupStart == null){
                if(node.val == last.val){
                    dupStart = last;
                    dupPrev = prev;
                }
                prev = last;
                last = node;
            } else {
               if(node.val != last.val){
                   dupPrev.next = node;
                   dupStart = null;
                   prev = dupPrev;
                   last = node;
               } else {
                   prev = last;
                   last = node;
               }
            }
            
            node = node.next;
        }
        if(dupStart != null){
            dupPrev.next = null;
        }
        return dummy.next;        
    }
}
