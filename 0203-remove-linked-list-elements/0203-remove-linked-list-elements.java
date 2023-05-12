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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode currentNode = head;
        ListNode prevNode = dummyNode;
        while(currentNode != null) {
            if(currentNode.val == val){
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return dummyNode.next;
    }
}