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
    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        if(size == 1){
            return true;
        }
        
        int count = 1;
        node = head;
        while(count != size / 2 + 1){
            count++;
            node = node.next;
        }
        ListNode reversed = reverse(node);
        count = size / 2;
        while(count > 0){
            count--;
            if(head.val != reversed.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        
        return true;
    }
}
