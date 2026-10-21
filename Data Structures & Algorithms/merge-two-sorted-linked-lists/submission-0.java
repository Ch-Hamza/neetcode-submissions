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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sortedListHead = new ListNode();
        // int maxLength = Math.max(getListLength(list1), getListLength(list2));
        ListNode currentNode = sortedListHead;

        while(list1 != null && list2 != null) {
            // System.out.println(list1.val);
            // System.out.println(list2.val);
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = list1 != null ? list1 : list2;

        return sortedListHead.next;
    }

    // private int getListLength(ListNode list) {
    //     int length = 0;
    //     while (list != null) {
    //         length++;
    //         list = list.next;
    //     }
    //     return length;
    // }
}