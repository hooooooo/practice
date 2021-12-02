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
    ListNode helper(ListNode odd, ListNode evenHeader, ListNode eventNext){
        if(odd == null){
            if(eventNext != null){
                eventNext.next = null;
            }
            return evenHeader;
        }     
        
        ListNode next = odd.next;
        if(eventNext != null){
            if(next != null){
                eventNext.next = next;
                eventNext = eventNext.next;
            }
        }
        
        
        ListNode nextOdd = null;
        if(next != null){
            nextOdd = next.next;
        }
    
        if(evenHeader == null){
            evenHeader = next;
            eventNext = evenHeader;
        }
    
        odd.next = helper(nextOdd,  evenHeader, eventNext);
        return odd;
    }
    
    public ListNode oddEvenList(ListNode head) {
        return helper(head, null, null);
    }
}
