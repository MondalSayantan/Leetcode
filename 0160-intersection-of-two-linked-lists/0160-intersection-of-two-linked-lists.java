/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        
        ListNode c1 = headA;
        ListNode c2 = headB;
        
        while(c1 != null){
            lengthA++;
            c1 = c1.next;
        }
        while(c2 != null){
            lengthB++;
            c2 = c2.next;
        }
        
        if(lengthA > lengthB) return getIntersectionNode(headB, headA);
        
        c1 = headA;
        c2 = headB;
        
        while(lengthB > lengthA){
            lengthB--;
            c2 = c2.next;
        }
        
        while(c1 != null && c2 != null){
            if(c1 == c2)
                return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }
}