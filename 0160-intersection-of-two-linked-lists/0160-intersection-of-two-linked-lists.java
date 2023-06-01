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
        HashSet<ListNode> set = new HashSet<>();
        ListNode c1 = headA;
        while(c1 != null){
            set.add(c1);
            c1 = c1.next;
        }
        ListNode c2 = headB;
        while(c2 != null) {
            if(set.contains(c2))
                return c2;
            c2 = c2.next;
        }
        return null;
    }
}