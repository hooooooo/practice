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
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(tmp != null){
            tmp = tmp.next;
            count++;
        }
        
        tmp = head;
        int reserve = count - count / 2;
        
        while(tmp != null){
             if(reserve == 0){
                 stack.push(tmp);
             } else {
                reserve --;
             }
            
             ListNode p = tmp;
             tmp = tmp.next;
             if(reserve == 0){
                p.next = null;    
             }
        }
        
        tmp = head;
        while(tmp != null){
            ListNode next = tmp.next;
            if(!stack.isEmpty()){
                ListNode t = stack.pop();
                t.next = next;
                tmp.next = t;
            }
            tmp = next;            
        }
        
    }
}
