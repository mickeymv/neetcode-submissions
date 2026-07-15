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
        List<ListNode> nodes = new ArrayList<>();

        ListNode node = head;

        while(node!=null) {
            nodes.add(node);
            node=node.next;
        }

        int i=0, j=nodes.size()-1;

        while(i<j && j<nodes.size()) {
            ListNode firstNode = nodes.get(i++);
            ListNode secondNode = nodes.get(j--);
            secondNode.next = firstNode.next;
            firstNode.next=secondNode;
        }

        // Terminate the list
        nodes.get(i).next = null;
    }
}
