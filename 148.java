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
    private ListNode dummy = new ListNode();
    
    ListNode merge(ListNode l, ListNode r){        
        ListNode p = dummy;
        while(l != null || r != null){
            if(l != null && r != null){
                 if(l.val  <= r.val){
                     p.next = l;
                     l = l.next;
                 } else {
                     p.next = r;
                     r = r.next;
                 }                     
             } else if(l != null) {
                 p.next = l;
                 l = l.next;
             } else {
                 p.next = r;
                 r = r.next;
             }
             p = p.next;
        }
        return dummy.next;
    }
    
    ListNode helper(ListNode head , int n){
        if(n <= 1){
            return head;
        }
        int half = n / 2;
        int t = half;
        ListNode tail = head;
        ListNode prev = head;
        
        while(t-- > 0){
            prev = tail;
            tail = tail.next;            
        }
        prev.next = null; 
        
        ListNode l = helper(head, half);
        ListNode r = helper(tail, n - half);
        return merge(l, r);        
    }
    
    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode t = head;
        while(t!= null){
            n ++;
            t = t.next;
        }
        return helper(head, n);
    }
}
