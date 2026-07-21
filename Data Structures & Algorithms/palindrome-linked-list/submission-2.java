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
    public boolean isPalindrome(ListNode head) {
        String string ="";

        ListNode node = head;

        while(node!=null) {
            string+=node.val;
            node=node.next;
        }

        for(int i=0,j=string.length()-1;i<j;i++,j--) {
            if(string.charAt(i)!=string.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}