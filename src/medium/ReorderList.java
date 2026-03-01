package medium;

import leetcode.ListNode;

import java.util.List;

public class ReorderList {
    int count;
    int toBeReversed;
    ListNode reversedList;

    public static void main(String args[]) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ReorderList r = new ReorderList();
        r.reorderList(a1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        reverseHalfList(head);
        merge2Lists(head, reversedList);

    }

    private void merge2Lists(ListNode head, ListNode reversedList) {
        ListNode lastNode = new ListNode();
        while(head !=null && reversedList !=null){
            ListNode headNext = head.next;

            lastNode.next = head;
            lastNode.next.next = reversedList;

            head = headNext;
            reversedList = reversedList.next;
            lastNode = lastNode.next.next;
        }

        if(head == null){
            lastNode.next = reversedList;
        } else {
            lastNode.next = head;
        }
    }

    private ListNode reverseHalfList(ListNode head) {
        count++;
        if (head.next == null) {
            reversedList = head;
            toBeReversed = count / 2;
            return head;
        }
        ListNode nextNode = reverseHalfList(head.next);
        if (toBeReversed > 1) {
            nextNode.next = head;
            head.next = null;
        } else if (toBeReversed == 1)
            head.next = null;
        toBeReversed--;
        return head;
    }
}
